# java-sdk-new-features

This is just a playground project to study the new JDK's features.

* Java 9: [examples](java9/README.md)  
* Java 10: [examples](java10/README.md)  
* Java 11: [examples](java11/README.md)
* Java 12: [No new language features](http://openjdk.java.net/projects/jdk/12/)  
    * [Microbenchmark Suite](http://openjdk.java.net/jeps/230)
* Java 13: [(Preview examples) Switch expressions, text blocks](java13/README.md)  

## Prerequisites:

### Install JDK 13

For Mac:
```bash
$ brew tap AdoptOpenJDK/openjdk
// if you want to list the available versions:
$ brew search adoptopenjdk

$ brew cask install adoptopenjdk13
```

### Install jenv (https://www.jenv.be/)

```bash
$ brew install jenv
```

#### Load jenv automatically by adding the following to your (bash,zsh) profile :

```bash
eval "$(jenv init -)"
jenv init -
```

#### enable jenv plugins:

```bash
$ jenv enable-plugin export

// and/or
$ jenv enable-plugin maven
$ jenv enable-plugin graddle
```

#### add the new jdk to jenv environment

```bash
$ jenv add /Library/Java/JavaVirtualMachines/adoptopenjdk-13.jdk/Contents/Home/

// another one 
$ jenv add /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/
$ jenv add /Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home/
```

#### change your jdk with:

```bash
$ jenv global 11.0

// or
$ jenv global 1.8
$ jenv global 11.0

// you can use 'local' instead of 'global'. this will create a .java-version file
// and the jvm version you chose will be set up for the current directory only.
// you can remove it to go back to global
$ jenv local 11.0
```
#### check the results:
```bash
$ jenv versions
```

#### update the PATH

```bash
$ alias jenv_set_java_home='export JAVA_HOME="$HOME/.jenv/versions/`jenv version-name`"'
$ jenv_set_java_home

// or if you have enabled the export plugin just type:
$ exec $SHELL -l

// or relogin
```

