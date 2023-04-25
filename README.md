# MakeItEasy_Library-Android
![GitHub](https://img.shields.io/github/license/guy-4444/SmartRateUsDialog-Android)
[![](https://jitpack.io/v/guy-4444/SmartRateUsDialog-Android.svg)](https://jitpack.io/#guy-4444/SmartRateUsDialog-Android)
![GitHub repo size](https://img.shields.io/github/repo-size/guy-4444/SmartRateUsDialog-Android)

A library for simple implementation of smart ranking.
The user will see a dialog every x time.
If the user gives a high score, he will be transferred to the Google store. If he gives a low score, he will only receive a thank you toast message.


## Setup
Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
	maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency:

```
dependencies {
	implementation 'com.github.RonShmaya:MakeItEasy_Library:1.00.00'
}
```
## Usage

###### Make Date Picker:
```java

/* For Call the Date Picker  -
  this -> activity
  callback_date -> there is a callback for result
*/  
MakeItEasy.getInstance().make_date_picker(callback_date,this);

// The Callback
    private MakeItEasy.Callback_date callback_date = date -> {
        // add some code here
        Toast.makeText(TestCommon.this, date.toString(), Toast.LENGTH_SHORT).show();
    };

```

###### Make Time Picker:
```java

/* For Call the Time Picker  -
  this -> activity
  callback_time -> there is a callback for result
*/  
MakeItEasy.getInstance().make_hour_minutes_picker(callback_time, TestCommon.this);

// The Callback
    private MakeItEasy.Callback_time callback_time = (hour, minutes) -> Toast.makeText(TestCommon.this,hour+" : "+minutes, Toast.LENGTH_SHORT).show();

```

###### Get Latitude and Longtitude by address:
```java

            LatLangRs latlang =  MakeItEasy.getInstance().getLocationFromAddress(Activity,
                    country.getText().toString(),
                    city.getText().toString() ,
                    street.getText().toString(),
                    streetNum.getText().toString());
            if (latlang == null){
                Toast.makeText(TestCommon.this, "not founded" ,Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(TestCommon.this, latlang.toString(),Toast.LENGTH_SHORT).show();
```
