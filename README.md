# TASK 처리하기

## 개요

---

### TASK는 TAG로 식별합니다.

- TAG는 1-9까지 숫자로 처리합니다.

### TASK를 처리하기 위해서 2가지 연산을 적용하고자 합니다.

- 맨 처음에는 어떠한 TASK도 존재하지 않습니다.
- `**create**` : TASK를 만듭니다.
    - 이때 만드는 TASK는 사용할 수 있는 태그 정보 중 가장 작은 값으로 할당됩니다.
    - 만들 수 있는 TASK가 없다면 생성 실패 횟수를 집계합니다.
- `**execute [tag]**` : 특정 태그의 TASK를 처리합니다. 해당 TASK는 처리되며, 할당되어있던 태그는 다시 활용가능한 상태로 변경됩니다.
    - 수행할 수 있는 TASK가 아니라면, 수행에 실패한 TASK의 태그 정보의 실패 횟수를 집계합니다.

### N개의 연산이 적용된 후 남아있는 태그의 번호를 출력해봅시다.

## 입력

---

- 첫 번째 줄에는 연산의 개수 N이 주어집니다.
    - 5 ≤ N ≤ 50
- 두 번째 줄부터 N개의 줄에 걸쳐 연산이 한 줄씩 주어집니다.
    - 주어지는 연산은 위 설명과 동일합니다.

## 출력

---

모든 연산을 적용한 후 아래의 결과를 출력합니다.

- 사용가능한 TASK의 태그를 공백으로 구분하여 오름차순으로 출력합니다.
- TASK 생성 실패 횟수를 출력합니다.
- TASK 수행 실패한 태그를 횟수와 함께 출력합니다.
    - 태그 실패 횟수를 내림차순으로 출력합니다.
    - 태그 실패 횟수가 동일하다면 태그의 오름차순으로 출력합니다.

## 테스트 케이스

---

### 예시1

**입력**

```java
6
create
create
create
create
create
execute 2
```

**출력**

```java
사용가능한 TAG: 2 6 7 8 9
TASK 생성 실패: 0
TASK 수행 실패한 태그:
```

### 예시2

**입력**

```java
10
create
create
create
create
create
create
create
create
create
create
```

**출력**

```java
사용가능한 TAG:
TASK 생성 실패: 1
TASK 수행 실패한 태그:
```

### 예시3

**입력**

```java
21
create
create
create
create
execute 11
create
create
create
create
create
create
execute 2
create
execute 2
execute 11
execute 2
execute 5
execute 5
execute 2
execute 5
execute 5
```

**출력**

```java
사용가능한 TAG: 2 5
TASK 생성 실패: 1
TASK 수행 실패한 태그: 5(3) 2(2) 11(2)
```
