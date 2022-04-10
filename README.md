# 스프링 배치 강의 예제 설명



## 예제 도식화
![image](https://user-images.githubusercontent.com/34643599/162607875-7ecd3cd4-6be7-4200-9406-6be824c2bb8c.png)

### 1. Job-1
  * 기능
    * 파일로부터 데이터를 읽어서 DB에 적재한다.
  * 세부 내용
    * 파일은 매일 새롭게 생성된다.
    * 매일 정해진 시간에 파일을 로드하고, 데이터를 DB에 업데이트한다.
    * 이미 처리한 파일은 다시 읽지 않도록 한다.

### 2. Job-2
  * 기능
    * DB 로부터 데이터를 읽어서 API 서버와 통신한다.
  * 내용
    * Partioning 기능을 통한 멀티 스레드 구조로 Chunk 기반 프로세스를 구현한다.
    * 제품의 유형에 따라 서로 다른 API 통신을 하도록 구성한다.(ClassifierCompositerItemWriter)
    * API 서버는 3개로 구성하여 요청을 처리한다.
    * 제품 내용과 API 통신 결과를 각 파일로 저장한다. (FlatFileWriter 상속)

### 3. Scheduler
  * 기능
    * 시간을 설정하면 프로그램을 가동시킨다.
  * 내용
    * 정해진 시간에 주기적으로 Job-1 과 Job-2 를 실행시킨다.
    * Quatz 오픈 소스를 활용한다.
