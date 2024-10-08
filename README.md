# TripMate_Server

## 👨‍👩‍👧‍👦 Contributers
|<img src="https://avatars.githubusercontent.com/u/163841621?v=4" width="128" />|<img src="https://avatars.githubusercontent.com/u/163849108?v=4" width="128" />|<img src="https://avatars.githubusercontent.com/u/81751105?v=4" width="128" />|<img src="https://avatars.githubusercontent.com/u/178886706?v=4" width="128" />|
|:---------:|:---------:|:---------:|:---------:|
|[김정훈](https://github.com/JHKim9824)|[백초이](https://github.com/Baekchoi)|[유정현](https://github.com/OliviaYJH)|[전원식](https://github.com/Wonsik1)|
|회원가입/로그인</br>가계부<br>경로 탐색|모임 개설, 삭제 및 목록 조회</br>모임 탈퇴 및 내보내기<br>실시간 채팅|모임 참여 및 수정</br>장소 검색<br>일정 추가|마이페이지</br>모임 검색|

## **💪 기획 배경**

편리함과 효율적인 이유로 혼자 여행을 떠나는 사람이 점차 증가하고 있습니다. 하지만 여행 동행자 찾기에 대한 수요가 증가하고 있습니다. 최근 비용 절감, 새로운 만남, 정보 수집 등의 이유로 온라인에서 여행 동행인을 많이 구하고 있지만 다양한 앱과 서비스에 분산되어 있어 사용자가 관리하는 데 불편함을 초래하고 있습니다.

이를 바탕으로 동행자를 찾고 함께 일정 조율과 지출 내역 공유를 편리하게 할 수 있는 플랫폼의 필요성이 대두되고 있습니다. 

## **💪 해결 컨셉**

- 여행 동행자를 찾는 여행객들이 원하는 모임에 편리하게 참여할 수 있도록 하고자 합니다.
- 함께 실시간 채팅으로 편리하게 소통하며 여행 계획을 만들 수 있습니다.
- 추가한 일정을 바탕으로 최적화된 동선을 추천하고, 경유지와 목적지 주변의 명소 및 맛집을 추천하는 기능도 제공하고자 합니다.
- 사용자는 모임 기간 내에 부분적으로 참여할 수 있어, 유연하게 동행할 수 있습니다.

## **💪 기대 효과**

- 이 플랫폼을 통해 사용자들은 여행에 함께할 동행자를 찾을 수 있습니다. 
동행자를 찾는 과정에서의 번거로움을 줄이고, 필터링된 조건을 통해 자신에게 맞는 동행자와 함께 여행할 수 있습니다. 실시간 채팅과 협력할 수 있는 일정 계획 기능을 통해 유기적이고 효율적인 여행을 준비할 수 있으며, 가계부 기능은 여행 후에도 간편하게 비용을 정산할 수 있도록 도와줍니다. 또한, 최적화된 동선 추천과 명소 추천 기능을 통해 실제 여행 중에도 시간과 비용을 절약할 수 있습니다. 
여행 중 함께한 동행자들과 새로운 관계를 형성하고, 같은 취미와 관심사를 가진 사람들과의 네트워크를 확장할 수 있는 기회를 제공합니다.
결과적으로 이 플랫폼은 단순한 여행 계획을 넘어, 사용자 간의 소통과 협력으로 새로운 관계를 맺을 수 있는 기회를 마련하며 사용자들에게 더 나은 여행 경험을 제공할 수 있을 것입니다.

## 기술 스택

- 공통
    - JAVA 17
    - Spring Boot 3.3.3
    - MySQL
    - Spring Data JPA
    - Hibernate
    - Spring Boot OpenAPI 3.0 + Swagger3
    - Junit
    - 페이지네이션 (마이페이지, 장소 검색, 모임)
- 회원가입 및 로그인
    - Spring Security
    - JWT
- 일정 계획
    - Spring WebSocket
- 모임 기능
    - Spring MVC
    - Spring Web
- 채팅 기능
    - WebSocket + STOMP

# ERD
![image](https://github.com/user-attachments/assets/2c1de3ed-57fb-4ed9-b26a-039b8b06581e)
