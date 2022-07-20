# GiantAPI v0.1.1
## Contents
****
- [Introduction](#introduction)
- [Installation](#installation)
- [Usage](#usage)
  - [ColorManager](#color-manager---hexdecimal-color-formatting)

## Introduction
****
The GiantAPI is primarily for private usage for myself AkaGiant.
Anyone is free to use this API in any way they see fit, but its primary
functions are to allow myself to get a better grasp on
using GitHub to manage packages like this, releases and to better store the
code I use over and over again.

## Installation
### Maven

#### Repository
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
#### Dependency
```xml
<dependency>
    <groupId>com.github.AkaGiant</groupId>
    <artifactId>GiantAPI</artifactId>
    <version>0.1.1</version>
</dependency>
```

### Gradle

#### Repository

Groovy:
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```

Kotlin:
```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}
```

#### Dependency

Groovy/Kotlin:
```groovy
dependencies {
    implementation 'com.github.AkaGiant:GiantAPI:0.1.1'
}
```

## Usage:

### Color Manager - HexDecimal Color Formatting
****
### Primary Class: ColorManager.java

Methods:
```java
formatColours(String msg); // Returns a String formatted with Hex
formatColours(List<String> unformatted); // Returns a List<String> formatted with Hex
```

Examples:
```java
// Example Standard
String message = ColorManager.formatColours("#ffffffmy &cmessage &b&lhere")
        
// Example List        
List<String> messages = new ArrayList<>();
messages.add("lol");
messages.add("lol2");
List<String> formattedMessages = ColorManager.formatColours(messages);
```

Plans for Improvement
<ul>
    <li>Add Gradient Color Coding
    <li>Add String[] option</li>
    <li>Add TextComponent Handling</li>
</ul>


