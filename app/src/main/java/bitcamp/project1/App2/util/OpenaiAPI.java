package bitcamp.project1.App2.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;

public class OpenaiAPI {
  String apiKey = System.getenv("OPENAI_API_KEY");
  private static final String API_URL = "https://api.openai.com/v1/chat/completions";
  private String assistantReply;

  public void sendRequest(int income, int outcome) {
    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();
    String Prompt1 =
        "다음은 나의 한 달 소비 습관 데이터입니다." + "수입:" + income + "지출:" + outcome + "이 데이터를 바탕으로 나의 소비 습관에 대한 총평과 개선점을 알려주세요. 한국어로 답장하세요.";
    String prompt = Prompt1;
    String requestBody = String.format(
        "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}], \"max_tokens\": 500}",
        prompt);
    try {
      RequestBody body =
          RequestBody.create(requestBody, MediaType.get("application/json; charset=utf-8"));
      Request request =
          new Request.Builder().url(API_URL).header("Authorization", "Bearer " + apiKey)
              .header("Content-Type", "application/json").post(body).build();
      try (Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          throw new IOException("Unexpected code " + response);
        }
        String responseBody = response.body().string();
        System.out.println("코멘트 로딩 중. . . "); // 추가된 줄
        JsonNode responseJson = objectMapper.readTree(responseBody);
        if (responseJson.has("choices") && responseJson.get("choices")
            .isArray() && responseJson.get("choices").size() > 0 && responseJson.get("choices")
            .get(0).has("message") && responseJson.get("choices").get(0).get("message")
            .has("content")) {
          assistantReply =
              responseJson.get("choices").get(0).get("message").get("content").asText();
        } else {
          System.err.println("Unexpected response format: " + responseBody);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void printAssistantReply() {
    System.out.println(assistantReply);
  }
}
