# 서울시 1인 가구를 위한 거주지 추천 서비스
![1  표지 후보 (3)1](https://github.com/user-attachments/assets/a962baed-9f70-4f3f-8f60-2ee251b0ca23)
- 1차 프로젝트 : UI & DB & Servlet
  - 3人 프로젝트 ( 2023.11.13 ~ 2024.02.02 )
  - [1차 프로젝트 URL](https://github.com/joonwonh/WhereHouse-server)
- 2차 프로젝트 : Spring & AWS
  - 1人 프로젝트 ( 2024.02.24 ~ 2024.04.19 )


## 프로젝트 소개
현재 대한민국 1인 가구 비율이 점점 증가하는 추세이며 특히 서울시 20대 1인 가구 비율이 가장 가파른 상승세를 보이고 있습니다. 

WHERE HOUSE는 서울시 거주를 희망하는 20대들에게 거주지 선정에 대한 정보를 제공하는 동시에 본인이 희망하는 조건의 거주지를 추천해주기 위한 서비스입니다.

거주지 추천의 기준은 가격, 안전성 편의성을 고려한 지역구 중심 추천으로 이루어집니다.

## 개발 환경
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"/><img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"><img src="https://img.shields.io/badge/ORACLE-F80000?style=for-the-badge&logo=oracle&logoColor=white"/><img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"><img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white"><img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white"><img src="https://img.shields.io/badge/Amazon%20EC2-FF9900?style=for-the-badge&logo=Amazon%20EC2&logoColor=white">

## 팀원 구성
<div align="center">

| **한준원** | **이재서** | **정범진**
| :------: |  :------: | :------: |
| [<img src="https://avatars.githubusercontent.com/u/96328871?v=4" height=150 width=150> <br/> @joonwonh](https://github.com/joonwonh) | [<img src="https://avatars.githubusercontent.com/u/153244723?v=4" height=150 width=150> <br/> @N0WST4NDUP](https://github.com/N0WST4NDUP) | [<img src="https://avatars.githubusercontent.com/u/85886967?v=4" height=150 width=150> <br/> @JungRepository](https://github.com/JungRepository) |

</div>

## 역할 분담

#### [팀장] 한준원
전체 UI제작 및 거주지 추천, 지역구 정보 페이지 개발

#### [팀원] 이재서
행정동 별 정보 페이지 개발(2차 프로젝트에서 해당 기능 제외)

#### [팀원] 정범진
게시판 및 로그인 / 회원가입 기능 개발


## 개발 기간 
**2023.11.13 ~ 2023.11.27 :** 프로젝트 기획

**2023.11.28 ~ 2023.12.10 :** UI 개발

**2023.12.11 ~ 2023.12.24 :** 데이터 수집 및 전처리

**2024.01.15 ~ 2024.02.02 :** JSP & Servlet을 이용한 웹 개발

**2024.02.24 ~ 2024.04.19 :** 전체 UI 수정 및 Spring으로 전환 후 배포

## 사용 데이터

1. 가격 데이터
   서울시의 각 구 별 평균 전세 보증금과 평균 월세 보증금, 월세금을 구하기 위해 선정하였습니다.<br>
   주 타겟층이 20대이기 때문에 10평 이하인 매물들로만 전처리 하였습니다.
    - 서울시 부동산 전월세가 정보 [2021~2022] (출처 : 서울 열린데이터 광장)

2. 편의 데이터
   20대들에게 가장 중요하다고 생각하는 편의 시설들인 음식점, 편의점, 카페, 올리브영, 다이소 데이터들을 선정하였고, <br>
   각 구 별 편의 데이터 개수 합계를 구한 뒤 내림 차순으로 정렬 후 비율 별로 편의 점수를 산정하였습니다.
    - 서울시 일반 음식점 인허가 정보 ( 구 별 음식점 수 데이터)
    - 서울시 휴게 음식점 인허가 정보 ( 구 별 편의점, 카페 수 데이터) (이하 출처 : 서울 열린데이터 광장)
    - 올리브영
    - 다이소 ( 이하 출처 : 각 회사 홈페이지 정보)
    
3. 안전 데이터
  안전과 가장 밀접한 데이터인 CCTV와 파출소 수, 검거율을 안전 데이터로 선정하고, <br>
  각 구 별 안전 데이터 개수 합계를 구한 뒤 내림 차순으로 정렬 후 비율 별로 안전 점수를 산정하였습니다.
    - 서울시 자치구 (연도별) CCTV 설치현황 ( CCTV 수 데이터)
    - 5대 범죄 발생현황 ( 검거율 데이터 )
    - 서울시 시내주요기관 (경찰·소방관서) 통계 ( 파출소 수 데이터) (이하 출처 : 서울 열린데이터 광장)

4. 인구 밀집도 데이터
    - 서울시 등록인구 (연령별/구별) 통계 (출처 : 서울 열린데이터 광장)

## 페이지 별 기능
### 🟦 [메인 페이지]

본 프로젝트의 메인 페이지입니다.

간단한 사이트 이용법과 거주지 추천, 지역구 정보, 게시판 등의 페이지로 이동할 수 있는 기능을 포함하고 있습니다.

https://github.com/user-attachments/assets/e3e57e44-1b4e-425c-975a-307536b44aca

<hr/>

### 🟨 [로그인&회원가입]

메인 페이지 네비바 우측에 위치한 로그인 및 회원가입 페이지입니다.
- 로그인이 되어있지 않은 경우 : 로그인 페이지로 이동, 회원이 아니라면 회원가입 페이지로 이동 가능.
- 로그인이 되어있는 경우 : 본인의 아이디가 표시됨과 동시에 개인정보 수정 혹은 로그아웃을 할 수 있는 기능으로 이동.

https://github.com/user-attachments/assets/a3373215-c366-4cd3-b375-aad940907afd

<hr/>

### 🟩 [거주지 추천]

- 사용자가 전세, 월세 중 하나를 택하고 보증금 혹은 월세금의 최댓값을 선택한 후, <br>
  안전 단계와 편의 단계의 중요도를 선택해주면 해당 정보들을 통합하여 총 3개의 지역구를 추천해주는 페이지입니다.
- 추천된 각 지역구의 평균 가격과 


https://github.com/user-attachments/assets/2c4c4c41-92f9-441f-9089-529284b7373c

<hr/>

### 🟧 [추천 지역 정보 비교]
https://github.com/user-attachments/assets/3af2643d-81c5-44bc-a0f5-43db42ffbdd0

<hr/>

### 🟪 [지역구 별 정보]
https://github.com/user-attachments/assets/4827c92d-84d6-4d0d-a94c-6ffbb23ce239

<hr/>

### 🟫 [게시판]
https://github.com/user-attachments/assets/805e5c5a-c948-458a-9327-3148186f394b

## 배포
(배포 중단 : 2024.05.30)

## 개선 목표





















