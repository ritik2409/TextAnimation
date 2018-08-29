# TextAnimation
[![Platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)

A library to animate text either Character by character transition or word by word transition.

# Usage

> Coming soon...

## Code Implementation

### XML

```
        <com.ritikgupta.textanimation.TextAnimation
        android:id="@+id/text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center" />
```      

### JAVA

> Defining extended TextView Class

``` 
TextAnimation textanimation = findViewById(R.id.text);
```

> Setting default delay time value

```
textAnimation.setDelay(300);
//time in milli seconds (default value is 100)
```

> Finally setting the Text and Type of Transition

```java
textAnimation.animateText("Whatever text you like comes here!", TextAnimation.CharWiseTransition);
```
#### OR
```                            
textAnimation.animateText("Whatever text you like comes here!", TextAnimation.WordWiseTransition);                            
```

### Sample

Word by Word transition

<img src="https://gfycat.com/DistantShyDartfrog" />(https://gfycat.com/DistantShyDartfrog)

Character by character transiiton

<img src = "https://gfycat.com/GoodWhisperedGiantschnauzer" />





        
