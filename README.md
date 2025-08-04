# Deploy Spring Boot 2 Kotlin Java 11 on Heroku

A comprehensive guide for deploying Spring Boot 2 applications built with Kotlin and Java 11 to the Heroku cloud platform.

📘 Blog Post: [Deploy Spring Boot 2 Kotlin Java 11 on Heroku](http://jarmx.blogspot.com/2022/01/deploy-spring-boot-2-kotlin-java-11-on.html)

## About Heroku

[Heroku](https://www.heroku.com/what) is a cloud platform that lets companies build, deliver, monitor and scale apps. It's the fastest way to go from idea to URL, bypassing all infrastructure headaches. You can create a free account to deploy your applications.

## Prerequisites

- Java 11
- Spring Boot 2.x
- Kotlin
- Git
- Heroku CLI

## Getting Started

### 1. Create a Heroku Account

1. Sign up for a free Heroku account at [https://signup.heroku.com/](https://signup.heroku.com/)
2. Complete the registration process
3. Log in to your Heroku dashboard

### 2. Create a New Heroku App

1. In your Heroku dashboard, click the dropdown in the top-right corner
2. Select **New** → **Create new app**
3. Enter a unique name for your application
4. Choose your preferred region
5. Click **Create app**

### 3. Install Heroku CLI

Install the Heroku Command Line Interface from the [official documentation](https://devcenter.heroku.com/articles/heroku-cli).

## Deployment Steps

### 1. Login to Heroku CLI

```bash
heroku login -i
```

Enter your Heroku credentials when prompted.

### 2. Initialize Git Repository

If you don't already have a Git repository for your project:

```bash
cd my-project/
git init
```

### 3. Connect to Heroku

Link your local repository to your Heroku app:

```bash
heroku git:remote -a your-app-name
```

Replace `your-app-name` with the name you chose when creating the Heroku app.

### 4. Configure Your Spring Boot Application

Ensure your `application.properties` or `application.yml` includes:

```properties
server.port=${PORT:8080}
```

This allows Heroku to assign the port dynamically.

### 5. Create system.properties

Create a `system.properties` file in your project root to specify Java 11:

```properties
java.runtime.version=11
```

### 6. Deploy Your Application

Add your files, commit, and push to Heroku:

```bash
git add .
git commit -am "Initial deployment"
git push heroku master
```

Or if using the main branch:

```bash
git push heroku main
```

## Project Structure

Your Spring Boot Kotlin project should follow this structure:

```
my-project/
├── src/
│   └── main/
│       ├── kotlin/
│       └── resources/
│           └── application.properties
├── build.gradle.kts (or build.gradle)
├── system.properties
└── README.md
```

## Example Endpoints

After successful deployment, your application will be available at:

```
https://your-app-name.herokuapp.com/
```

Example service endpoints:
- `https://your-app-name.herokuapp.com/services/hello`
- `https://your-app-name.herokuapp.com/services/hello/henry`

## Troubleshooting

### Common Issues

1. **Port Configuration**: Ensure your application uses the `PORT` environment variable
2. **Java Version**: Verify `system.properties` specifies Java 11
3. **Build Configuration**: Check that your `build.gradle.kts` includes the Spring Boot plugin

### View Logs

To debug deployment issues:

```bash
heroku logs --tail -a your-app-name
```

## Additional Configuration

### Environment Variables

Set environment variables for your application:

```bash
heroku config:set VARIABLE_NAME=value -a your-app-name
```

### Database Configuration

For database connectivity, add the appropriate dependencies and configure your `application.properties`:

```properties
spring.datasource.url=${DATABASE_URL}
spring.jpa.hibernate.ddl-auto=update
```

## Build Configuration

Ensure your `build.gradle.kts` includes:

```kotlin
plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.7.0"
    kotlin("plugin.spring") version "1.7.0"
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
```

## Resources

- [Heroku Documentation](https://devcenter.heroku.com/)
- [Spring Boot on Heroku](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku)
- [Heroku CLI Reference](https://devcenter.heroku.com/articles/heroku-cli-commands)

## License

This project is licensed under the MIT License - see the LICENSE file for details.
