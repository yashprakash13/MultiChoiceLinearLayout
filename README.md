## MultiChoiceLinearLayout
[![](https://jitpack.io/v/yashprakash13/MultiChoiceLinearLayout.svg)](https://jitpack.io/#yashprakash13/MultiChoiceLinearLayout)
An android library that mimics the functionality of a Radio Group and provides a custom layout for option selections.

![Library Preview](https://github.com/yashprakash13/MultiChoiceLinearLayout/blob/master/preview_gif.gif "Library Preview")

### Start using in your project!

* Just add dependencies in
  * Project level gradle:
   
  ```gradle
      allprojects {
         repositories {
            .
            .
            .
            maven { url 'https://jitpack.io' }
            .
            .  
          }
    } 
    ```
  * And app level gradle: 
      
  ```gradle
  dependencies {
      .
      .
      .
      implementation 'com.github.yashprakash13:MultiChoiceLinearLayout:1.1'
      .
      .
  }
  ```
and you are good to go!
       
#### For two choices:  
```xml
<tech.pcreate.multichoicelayout.MultiChoiceLayout
        android:id="@+id/multichoices"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        app:backType="stroke"
        app:backStrokeWidth="3"
        app:backgroundColor="@color/colorPrimaryDark"
        app:opt1="@string/monthly"
        app:opt1TColor="@color/white"
        app:opt2="@string/yearly"
        app:opt2TColor="@color/white"
        app:ignoreThird="true"
        app:ignoreFourth="true"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/appBarLayout"
        app:selectedOptionBackground="@color/white_depth">

    </tech.pcreate.multichoicelayout.MultiChoiceLayout>
```
#### For three choices 
* Simply remove 
```xml
<tech.pcreate.multichoicelayout.MultiChoiceLayout
        .
        .
        .
        app:ignoreThird="true"
</tech.pcreate.multichoicelayout.MultiChoiceLayout>
```
* and add: 
```xml
<tech.pcreate.multichoicelayout.MultiChoiceLayout
        .
        .
        .
        app:opt3="@string/yourString"
        app:opt3TColor="@color/yourColor"
</tech.pcreate.multichoicelayout.MultiChoiceLayout>
```
#### For four choices
* Remove: 
```xml
<tech.pcreate.multichoicelayout.MultiChoiceLayout
        .
        .
        .
        app:ignoreThird="true"
        app:ignoreFourth="true"
</tech.pcreate.multichoicelayout.MultiChoiceLayout>
```
* and add:
```xml
<tech.pcreate.multichoicelayout.MultiChoiceLayout
        .
        .
        .
        app:opt3="@string/yourString"
        app:opt3TColor="@color/yourColor"
        app:opt4="@string/yourString"
        app:opt4TColor="@color/yourColor"
</tech.pcreate.multichoicelayout.MultiChoiceLayout>
```

#### Set a ClickListener for Options:
* Add this line to your Activity/Fragment:
```java
MultiChoiceLayout multiChoiceLayout = findViewById(R.id.multichoices);
multiChoiceLayout.setOnClickListener(this);
```
* and implement this Interface:
```java
public class MyActivity implements MultiChoiceLayout.MultiChoiceOnclick {
. . .
```
* Then, get the click action like this:
```java
    @Override
    public void onMultiChoiceLayoutClick() {
        if(MultiChoiceLayout.getSelection() ==  1){
            // Do some work
        }
        else if(MultiChoiceLayout.getSelection() ==  2){
            // Do some work
        }
        ...
        //so on
    }

```
#### If you want to use Java :
```java
        // For setting three choices use:
        multiChoiceLayout.setOptionText(option1, option2, option3, null);
        
        // And add fourth option as the ignore attribute:
        multiChoiceLayout.setIgnoreChoices(false, false, true);
        
```
Likewise for Two choices, one choice or all four choices.

#### Set custom attributes like this:
```java

        //Background of the layout can be either solid or stroke :
        multiChoiceLayout.setBackground(R.color.color_1, 4, MultiChoiceLayout.STROKE);  // Use for solid background : MultiChoiceLayout.SOLID, width parameter will be ignored.

        // Selected Option Background color:
        multiChoiceLayout.setSelectedBackgroundColor(R.color.color_1);
        
        
        // Option Text color:
        multiChoiceLayout.setOptionTextColor(R.color.color_1);

```


#### Buy me a Coffee!
If you like this library, please show your support by : 
<a href='https://ko-fi.com/G2G3R125' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi3.png?v=0' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>
