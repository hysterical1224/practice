package com.example.mavendemo;

public class note {
    //mvn几个阶段：
//    编译，测试，打包，安装，发布
    //mvn compile：
    //执行生命周期阶段：compile 阶段。
    //主要操作：编译项目的源代码（src/main/java 中的 Java 源代码）。
    //输出目录：编译后的类文件会放置在 target/classes 目录中。
    //依赖范围：compile 阶段通常只处理编译时依赖，即项目的源代码和编译时需要的依赖项。
    //mvn compile 主要用于在构建过程中编译项目源代码，以便后续阶段可以使用这些编译后的类文件。


    //mvn test:
    //mvn test 是 Maven 命令，用于执行项目中的测试。执行此命令时，Maven 会按照项目的配置查找测试类，然后运行这些测试类中的测试方法。
    // 以下是 mvn test 命令的一些关键特点：
    //
    //测试框架： mvn test 使用项目中配置的测试框架（例如 JUnit、TestNG 等）来运行测试。
    //
    //测试类和方法： mvn test 会查找项目中命名符合测试命名约定的测试类（通常以 "Test" 结尾）和测试方法（通常以 "test" 开头）。
    // 这些测试类和方法必须在项目的测试源代码目录中。
    //
    //测试报告： 执行测试后，Maven 会生成测试报告，通常位于 target/surefire-reports 目录中。这些报告包括测试的结果、耗时等信息。
    //
    //测试范围： mvn test 默认只运行测试范围为 test 的测试。
    //如果项目中有其他测试范围（例如 integration-test），你可以使用 -Dtest 参数指定要运行的测试范围，如 mvn test -Dtest=integration。
    //
    //生命周期阶段： mvn test 执行 Maven 生命周期中的 test 阶段。

    //mvn package
    //    mvn package 是 Maven 命令之一，用于构建项目并打包成可分发的输出文件（通常是 JAR、WAR、或其他格式）。执行此命令时，Maven 会执行一系列构建任务，包括编译源代码、运行测试、将生成的类文件打包，最终生成可部署的构建产物。以下是关于 mvn package 命令的一些重要信息：
    //
    //    构建类型： mvn package 会执行 Maven 生命周期中的 package 阶段。在该阶段，Maven 将编译项目的源代码，运行测试，并将项目的构建产物打包成一个可发布的文件。
    //
    //    构建产物： 构建产物的类型取决于项目的类型和配置。例如，对于 Java 项目，构建产物通常是 JAR 文件，对于 Web 项目，通常是 WAR 文件。构建产物通常位于 target 目录下。
    //
    //    依赖解析： 在执行 mvn package 时，Maven 会解析项目的依赖关系，确保所有依赖都可用，并将它们包含在构建产物中。这意味着项目的 JAR 文件会包含所有依赖的类文件，以便项目可以在运行时正常工作。
    //
    //    构建报告： Maven 会生成构建报告，其中包括构建过程中的详细信息，如编译错误、测试结果和构建成功或失败的状态。
    //
    //    生命周期： mvn package 会触发 Maven 构建生命周期的 package 阶段。生命周期是一系列阶段的集合，按顺序执行，以便构建项目。


    //mvn install：
    //执行生命周期阶段：install 阶段。
    //主要操作：将项目构建输出（通常是 JAR 或 WAR 文件）安装到本地 Maven 存储库（~/.m2/repository）中，以便其他项目可以在其依赖中引用。
    //输出目录：构建后的文件（通常是 JAR 或 WAR 文件）会被复制到本地 Maven 存储库中，并以坐标形式存储（例如，groupId/artifactId/version 结构）。
    //依赖范围：install 阶段通常涉及构建输出的所有内容，包括编译后的类文件、资源文件和库文件。
    //mvn install 通常用于将构建的库或模块安装到本地 Maven 存储库，以便其他项目可以将其作为依赖项引用。









}
