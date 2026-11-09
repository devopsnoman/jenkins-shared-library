def call() {
    sh 'trivy fs . -o trivy-report.txt'
}
