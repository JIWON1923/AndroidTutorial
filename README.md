# AndroidTutorial
- 예쁘지는 않지만 기똥찬 튜토리얼

## Data Binding Project
- 데이터를 선언적 방식으로 결합 할 수 있도록 도와주는 라이브러리이다.
- 데이터 바인딩을 사용하면, 데이터를 UI 요소에 연결하기 위해 필요한 코드를 최소화할 수 있다.
    - 아키텍처 패턴에 유용하게 사용된다.
    - 하지만 조금 더 학습이 필요한 부분이다!

```kotlin
    // build.gradle(앱 수준)
    dataBinding {
        enabled true
    }
```

```kotlin
    private lateinit var binding: ActivityMainBinding
    
    setContentView(R.layout.activity_main)
    
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
```

## Dice App
- 랜덤으로 주사위를 돌리는 앱이다. 
- Random을 이용하여, 랜덤 숫자를 추출하여, 이미지 리소스를 변경시킨다.


```kotlin
val dice1 = Random.nextInt(1, 6)
val dice2 = Random.nextInt(1, 6)
```
<img src = "https://user-images.githubusercontent.com/68676844/231817350-952cb0ca-0e7f-4f77-bd8f-a713631a6a06.gif" width = 250>

## Back button Tapped
- 뒤로가기 버튼을 연속으로 두 번 눌렀을 때, 앱을 종료시키는 기능
- onBackPressed()를 재정의하여 구현한다.

``` kotlin
    override fun onBackPressed() {
        Log.d("Main", "backbutton")

        if (isDoubleTapped) {
            finish()
        }

        isDoubleTapped = true
        Toast.makeText(this, "종료하시려면, 한 번 더 눌러주세요.", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            isDoubleTapped = true
        }, 2000)
    }
```
<img src = "https://user-images.githubusercontent.com/68676844/231817665-c1ce99f0-5b78-49e6-a0c3-8af86a3a769e.gif" width = 250>


## life Quotes App
- 앱이 켜질 때 마다 랜덤 명언이 화면에 보이고, 전체 명언 보기를 누르면 리스트뷰가 출력된다.
- List View 작성 방법을 학습했다.
- List View Adapter, Data, listview item.xml간 데이터를 주고받으며 화면에 표시한다.

<img src = "https://user-images.githubusercontent.com/68676844/231818584-31775484-a307-465f-888c-a8a38fe3fe69.gif" width = 250>

## Framgent App
- iOS의 TabView를 구현한다. (andorid에서는 Navigation이라고 불린다.)
    - 하나의 Activity에서 Fragment를 전환하여 구현하는 방식이다.
    - 속성 프로젝트니까.. UI는 눈감아주자!!!
    
<img src = "https://user-images.githubusercontent.com/68676844/231818594-48e9cdee-5f54-4bbf-89d2-766cd05ac0e1.gif" width = 250>


## Trot Music List App
- Navigation을 활용하여 가수 별 음악 리스트를 보여주는 앱이다.

<img src = "https://user-images.githubusercontent.com/68676844/231818861-5cabbde5-e633-4525-b538-a8266ac3412c.gif" width = 250>

## Diet Memo App
- Firebase의 익명로그인 기능과 realtime database 기능을 활용했다.
    - Splash Activity에서 로그인이 되어있다면 해당 유저로 정보를 보여주고, 없다면 새로 로그인하여 작성할 수 있도록 작성했다.
    
<img src = "https://user-images.githubusercontent.com/68676844/231819135-58cecf2a-3873-4d60-bd11-5595192a37d2.gif" width = 250>

## Mango Contents App
- firebase의 이메일 회원가입 기능, realtime database를 활용했다.
    - 북마크 기능을 통해 원하는 장소를 저장하고, 다시 불러올 수 있다.
- WebView를 이용하여 망고 플레이트 사이트로 이동한다.
<img src = "https://user-images.githubusercontent.com/68676844/231820178-445fb15d-eb99-47db-8f28-542dff3cfcfe.gif" width = 250>


## D-day Counter App
- 시작일과 종료일을 입력하면 Calendar를 이용하여 D day를 카운트 할 수 있는 기능이다.
