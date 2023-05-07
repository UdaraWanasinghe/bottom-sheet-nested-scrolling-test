Run tests

```shell
./gradlew app:connectedDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.example.bottomsheettest.BottomSheetDialogInstrumentedTest
```

It requires JDK 17 to run.

```shell
-Dorg.gradle.java.home=/path/to/jdk/17
```

Expected result: testOldBottomSheetDialogNestedScrolling test will fail.