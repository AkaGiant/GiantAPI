# GiantAPI v0.1.2
## Contents
****
- [Introduction](#introduction)
- [Installation](#installation)
- [Usage](#usage)
  - [ColorManager](#color-manager---hexdecimal-color-formatting)
  - [Config](#config---handler-for-configuration-files-root-level)

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
    <version>0.1.2</version>
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
    implementation 'com.github.AkaGiant:GiantAPI:0.1.2'
}
```

## Usage:

### Color Manager - HexDecimal Color Formatting
****

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

### Config - Handler for Configuration Files (root level)
****
Examples:
```java
// Example Standard
// USE MUST CREATE THE FILE UNDER RESOURCES TOO.
Config config = new Config(plugin, "config");
Double defaultBalance = config.getConfig().getDouble("defaultBalance");
config.getConfig().set("defaultBalance", 100);
config.saveConfig();

// How to reload
config.reloadConfig();
```
```java
Config config;

config = new Config(plugin, "configName", "subDir/subSubDir");
```
```java
List<File> files = Config.getAllConfigurationFiles(this)
for (File file : files) {
    Config.reloadConfig(file);
}
```


Plans for Improvement
<ul>
    <li>Method to create dynamic files without the need to create them under the resources' directory (these would be useful for files that are created dynamically (menus, player files etc...</li>
    <li>Method to instantiate the plugin once rather tha having to implement it into every method that requires it.</li>
</ul>


