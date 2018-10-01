# Lottoland Assessment (Rock-Paper-Scissors)

## How to run
- **Application:** `./gradlew bootRun`, then navigate to `http://localhost:8080/index.xhtml`
- **Tests:** `./gradlew test`

## Made with
- Java 8
- Spring Boot and Joinfaces starter for JSF
- JSF 2.0 and Primefaces
- Mockito and JUnitparams for unit testing

## Considerations
- I tried to keep this simple and offered the whole assessment in a single unit. However, that makes the application
not so scalable. For that case, I could have delivered two deployables:
The former with the frontend (consisting on pages, web app configurations, JSF managed beans, etc), and the latter with
the backend (mainly a set of endpoints that enables data handling/retrieval and business wise operations).
But, as I said, I think that was out of scope of the assessment.
- I followed TDD, so basically all classes that are performing some logic have a test,
and they have been made following those tests as specifications on what they should do.
However, I made a mistake on one commit that could have broken a CD pipeline. I fixed that as soon as I realized, but I
am sorry about that.
- I used Primefaces as I think it simplifies definition of components inside pages.
- I didn´t put emphasys on visual style, since it seems that is not required for the assessment, so pages are
rendered with default style.  
- Hope you like this code.
