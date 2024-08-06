# 💰 Account Book

- Git : https://github.com/bovob/bitcamp-project1

  <br>

## 1. 프로젝트 소개

### 프로젝트 명 : Account Book

### 프로젝트 개발 기간 : 2024-06-27 ~ 2024-07-01

### 소개

- 개인이 사용할 수 있는 가계부 프로그램 입니다.
- 수입 & 지출 : 각 수입&지출을 작성할 수 있습니다.
- 목표 : 예산을 설정하여 해달 월의 목표를 정할 수 있습니다.
- 고정비 : 고정적으로 지출되는 지출을 설정할 수 있습니다.
- 월결산 : 선택한 월의 종 수입&지출을 보여줍니다.

  <br>

## 2. 팀원 구성

<div align="center">

| **이재욱** |                                               **김주연**                                                 |
| :--------: |:-----------------------------------------------------------------------------------------------------:|
| <img src="https://avatars.githubusercontent.com/u/66761864?v=4" height=150 width=150> <br/> [@bovob] | <img src="https://avatars.githubusercontent.com/u/148393841?v=4" height=150 width=150> <br/> [@uripup] |

</div>
<br>

## 3. 개발 환경

<img src="https://img.shields.io/badge/Java-007396?style=flastic&logo=OpenJDK&logoColor=white"/>  <img src="https://img.shields.io/badge/IntelliJ-000000?style=flastic&logo=intellijidea&logoColor=white"/>
<br>

## 4. 역할분담

### 이재욱

* **수입** : 수입을 CRUD를 통해 관리할 수 있습니다.
* **목표** : 특정 날짜를 지정하여 예산을 정하고 지출챌린지를 진행 
             <br> 성공여부를 나타내어 확인 및 남은 금액을 확인합니다.
* **월결산** : 특정 월의 수입/지출을 나타냅니다.

### 김주연

* **지출** : 지출을 CRUD를 통해 관리할 수 있습니다.
* **고정비** : 특정 날짜/월을 지정하여 고정적인 지출을 입력합니다.
* **월결산** : OpenAI의 API를 통하여 해당 월에 대한 평가를 나타낸다.

  <br>

## 5. 프로젝트 구조

``````
📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂bitcamp
 ┃ ┃ ┃ ┗ 📂project1
 ┃ ┃ ┃ ┃ ┗ 📂App
 ┃ ┃ ┃ ┃ ┃ ┣ 📂command
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GoalCommand.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜IncomeCommand.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MonthlyCommand.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OutcomeCommand.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂util
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OpenaiAPI.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OutcomeComparator.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Prompt.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂vo
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Css.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Goal.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Income.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Outcome.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜App.java
``````
<br>

## 6. 기능

### 1. 수입
- 수입을 CRUD를 통하여 입력할 수 있다.
- 수입 변경/삭제 시 no를 이용한다.
 ![Income](https://github.com/user-attachments/assets/f9348201-bb9f-4fb8-8cdb-9256d98d8905)


### 2. 지출
- 지출을 CRUD를 통하여 입력할 수 있다.
- 지출 변경/삭제 시 no를 이용한다.
 ![Outcome](https://github.com/user-attachments/assets/4e1b7e32-30d6-41f7-bec9-65b9583d761e)


### 3. 목표
- 특정 월을 기준으로 예산을 설정한다.
- 해당 월의 예산-지출을 통하여 성공여부를 판단한다.
 ![Goal](https://github.com/user-attachments/assets/2802337b-68e3-4a36-ac95-fd01c8e0df23)


### 4. 고정비
- 특정 날짜/월을 기준으로 고정적인 지출을 설정한다.
- 월 결산에 특정 날짜/월(1일)에 지출로 설정된다.
 ![FixOutcome](https://github.com/user-attachments/assets/46649c5a-af8d-4c10-a6c8-e14f55ebd888)


### 5. 월결산
- 특정한 달을 입력하면 해당한 달의 수입/지출/총합을 출력한다.
- OpenAI 의 답변을 출력해준다.
![Monthly](https://github.com/user-attachments/assets/43007cad-8cc5-4246-8468-2c2be66be753)



<br>

## 7. 후기
첫 프로젝트로 아직 CRUD 구현이 미숙하고 
각 클래스에 담겨있는 field나 instance 값을 제대로 전달하지 못해 많이 헤메었지만
데이터의 흐름과 각 클래스의 변수들을 그려가며 이해하여 결국 기한내에 완성해냈다.
