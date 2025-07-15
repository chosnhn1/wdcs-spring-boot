# Chapter 4

원 책은 AWS Lightsail을 이용한 배포 & PostgreSQL 적용을 상정하고 작성되어 있음

나는 on-premise Ubuntu Server에서의 배포 & PostgreSQL Docker Image를 사용한 배포를 상정

(실제로는 그렇게까지 차이가 나지는 않을 것: 같은 nginx를 이용해 같은 Java Spring Project를 Postgresql DB를 통해 서비스하는 것임)


## Nginx 설정 시 유의점

nginx에 서비스 등록 시에는
`/etc/nginx/sites-available`에 설정 파일을 작성 후 `/etc/nginx/sites-enabled`에 링크하는 방식으로 사용
```shell
sudo ln -s /etc/nginx/sites-available/my-service.conf /etc/nginx/sites-enabled/my-service.conf
```

설정이 바뀌었으므로 서비스 리로드
```shell
sudo systemctl restart nginx
```

오류가 발생할 경우 다음으로 체크:
```shell
sudo nginx -t
```
나의 경우 `sites-available/sbb`의 `$`를 `#`로 잘못 입력함

```shell
sudo nginx -t && sudo systemctl restart nginx
```

## Bash Script 작성 시 유의점

Windows 환경에서 작성 후 Linux 서버에서 스크립트 실행 시 안 되는 경우 있음

(vim 등으로 파일을 열어도 단박에 보이지 않기 때문에 유의해야)

윈도우 환경의 문장바꿈 문자(CRLF) 때문에 안 읽히는 경우에는 다음 방법으로 해결
* `dos2unix` 툴을 설치해서 파일 변환
  * `dos2unix script_file.sh`
* `sed`, `tr` 명령어 등으로 수동 변환

