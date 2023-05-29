# k8s-debugger

The k8s debugger is a simple spring boot mvc application that contains a simple html page.
This app is designated to be hosted on a kubernetes environment.
It has only two features :
- A simple html home page
- Some rest api endpoints

For the html page. It's an index.html which exposes some data of the current container (on which the app is running)
like :
- The Hostname
- The IP Address
- The Port on which the app is running
- If you have several containers, each one will have its own background color

The rest api endpoints are the actuator endpoints to check the health and the build info of the application. You can check them on :
- /actuator/health
- /actuator/liveness
- /actuator/readiness
- /actuator/info

## Requirements

- JDK 20
- You IDE

## Run

### Local
You can run the app on your localhost as a simple spring boot application and check the home page from :
- http://localhost:8080/

### Minikube

You can also run the app on your minikube environment using the yaml file under :
- deploy/k8s-debugger.yaml

Get the service external url :

```bash
minikube service k8s-debugger-service -n default --url
```

```text
http://172.19.242.246:31003
```

and check then the url from your browser.

## Build

If you check the sources, you'll find two important files for the build :
- build.sh
- .github/workflows/build-push-docker-image.yml

You can run the ``build.sh`` script which will ask you for the type of the build. 
If this is a test version, you can choose ``uat`` otherwise if this is a corporate version choose ``production``.

The script will push the tag :
- ``uat`` : if you select the first option
- ``vX.X.X`` : which is your corporate version if you select the second option

After pushing, the ``Build and Push Docker Image`` github actions will be triggered.
This workflow, will :
- Define the docker image tag : which is ``uat`` or ``vX.X.X`` suffixed by the current date-time and the sha1 of the last commit.
- Package the project
- Build the docker image
- Push the docker image with the defined tag and a latest tag

The docker image will be hosted on the dockerhub account, but feel free to change that :
- https://hub.docker.com/repository/docker/mouhamedali/k8s-debugger/general

## References
- https://mkyong.com/spring-boot/spring-boot-hello-world-example-thymeleaf/
- https://spring.io/guides/gs/testing-web/
- https://medium.com/@johnidouglasmarangon/accessing-docker-tag-as-an-environment-variable-inside-a-docker-container-project-6d944cab4ff7
- https://minikube.sigs.k8s.io/docs/handbook/accessing/
- https://github.com/docker/build-push-action#examples
- https://event-driven.io/en/how_to_buid_and_push_docker_image_with_github_actions/
- https://dev.to/jpoehnelt/environment-variables-in-github-docker-build-push-action-23pj

### Nigel Brown work
Inspired from the nginxhello repo :
- https://github.com/nbrownuk/gitops-nginxhello
- https://github.com/nbrownuk/gitops-app-nginxhello
- https://github.com/nbrownuk/gitops-config-nginxhello
- https://app.pluralsight.com/library/courses/gitops-kubernetes-flux-2-automate-deployments-using/table-of-contents
