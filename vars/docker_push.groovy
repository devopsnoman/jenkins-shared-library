def call(String credentialId, String imageName) {
    withCredentials([usernamePassword(
        credentialsId: credentialId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh '''
            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
            docker push "$IMAGE_NAME"
            docker logout
        '''
    }
}
