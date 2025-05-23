# Setup CLI

Setup is a Command line utility designed to help developers when they start working with a new repository.

![](./docs/setup-cli-screenshot.png)

## How to build in local

```bash
sdk env install

# Update cursor rules in local
./load-remove-git-submodules-cursor-rules-java.sh r
./load-remove-git-submodules-cursor-rules-tasks.sh r
./load-remove-git-submodules-cursor-rules-agile.sh r
touch .gitmodules
./load-remove-git-submodules-cursor-rules-java.sh c
./load-remove-git-submodules-cursor-rules-tasks.sh c
./load-remove-git-submodules-cursor-rules-agile.sh c

# Setup cli
./mvnw clean validate -U
./mvnw clean verify
./mvnw clean verify surefire-report:report
./mvnw clean verify jacoco:report -Pjacoco
jwebserver -p 8000 -d "$(pwd)/target/site/jacoco"


./mvnw versions:display-dependency-updates
./mvnw versions:display-plugin-updates
./mvnw versions:display-property-updates

./mvnw versions:set -DnewVersion=0.9.0
./mvnw versions:commit
```

## How to use the CLI

```bash
./mvnw clean package
java -jar ./target/setup-0.9.0.jar
java -jar ./target/setup-0.9.0.jar --help
java -jar ./target/setup-0.9.0.jar init
java -jar ./target/setup-0.9.0.jar init --help
java -jar ./target/setup-0.9.0.jar init --devcontainer
java -jar ./target/setup-0.9.0.jar init --cursor java
java -jar ./target/setup-0.9.0.jar init --cursor tasks
java -jar ./target/setup-0.9.0.jar init --cursor agile
java -jar ./target/setup-0.9.0.jar init --cursor java-spring-boot
java -jar ./target/setup-0.9.0.jar init --cursor java-quarkus
java -jar ./target/setup-0.9.0.jar init --maven
java -jar ./target/setup-0.9.0.jar init --spring-cli
java -jar ./target/setup-0.9.0.jar init --quarkus-cli
java -jar ./target/setup-0.9.0.jar init --github-action
java -jar ./target/setup-0.9.0.jar init --editorconfig
java -jar ./target/setup-0.9.0.jar init --sdkman
jar tf ./target/setup-0.9.0.jar
```

## How to use from Jbang

```bash
jbang cache clear
jbang catalog list jabrena
jbang setup@jabrena
```

## References

- https://www.cursor.com/
- https://docs.cursor.com/context/rules-for-ai
- https://github.com/jabrena/cursor-rules-java
- https://github.com/jabrena/cursor-rules-tasks
- https://github.com/jabrena/cursor-rules-agile
- https://github.com/jabrena/jbang-catalog

### Developer links

- https://picocli.info/
- https://github.com/jbangdev/jbang-jash
- https://code.visualstudio.com/docs/devcontainers/containers
- https://www.jetbrains.com/help/idea/dev-containers-starting-page.html
- https://github.com/spring-projects/spring-petclinic/tree/main/.devcontainer
- https://sdkman.io/
- https://sdkman.io/usage/#env-command
- https://maven.apache.org/guides/index.html
- https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
- https://docs.spring.io/spring-boot/cli/index.html
- https://keepachangelog.com/en/1.1.0/
- https://www.eclemma.org/jacoco/trunk/doc/maven.html

Powered by [Cursor](https://www.cursor.com/)
