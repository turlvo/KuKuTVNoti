# 'KuKuTVNoti' Install Guide

# 0. Preparing

To connect to LG WebOS TV, need to enable 'LG CONNECT APPS' option.
Just follow below official site's guide.


http://www.lg.com/uk/support/product-help/CT00008334-1437131798537-others



# 1. Install 'KuKuTVNoti' Daemon

1-1) 'KuKuTVNoti' Docker Image download

```
# docker search kukutvnoti
# docker pull turlvo/kukutvnoti
```

1-2) Execute 'KuKuTVNoti' container 

```
# docker run -ti --name kukutvnoti -v /home/kukutvnoti:/keys -p 8383:8383 turlvo/kukutvnoti
```
<Change '/home/kukutvnoti' to your own directory that used to store TV's key>
After run container, push Ctrl + P + Q to quit.
If the container is stopped, just start container to use 'docker start'

1-3) Enable auto run 'KuKuTVNoti' when rebooted

```
# sudo vim /etc/systemd/system/kukutvnoti.service

<kukutvnoti.service File content>
[Unit]
Description=KuKuTVNoti container
Requires=docker.service
After=docker.service

[Service]
Restart=always
ExecStart=/usr/bin/docker start -a kukutvnoti
ExecStop=/usr/bin/docker stop -t 2 kukutvnoti

[Install]
WantedBy=multi-user.target

# sudo systemctl enable /etc/systemd/system/kukutvnoti.service
```




# 2. Install 'KuKuTVNoti' DTH

2-1) Add ST IDE에서 'KuKuTVNoti' DTH 

https://github.com/turlvo/KuKuTVNoti/blob/master/devicetypes/turlvo/kukutvnoti.src/kukutvnoti.groovy

2-2) Add a'KuKuTVNoti' at ST IDE에서

'My Devices' -> 'New Device'



- Name : any device name you want
- Device Network Id : any value not same with other device
- Type : select installed 'KuKuTVNoti' DTH
- Version : Published
- Hub : Must select own hub



2-3) Configuration installed 'KuKuTVNoti' device
(Can change values at the device Thing's setting)

- noti1msg ~ noti8msg : message to map tile buttons
- serverIp : Server's IP that KuKuTVNoti' daemon is run
- serverMac : Server's MAC address that KuKuTVNoti' daemon is run
- serverPort : 8383
- tvIp : LG WebOS TV's Local IP address

 

# 3. 'KuKuTVNoti' Thing
3-1) Thing screen
<img src='http://kuku.pe.kr/wordpress/wp-content/uploads/2017/10/IMG_03401-1024x819.jpg'>

3-2) Thing Setting screen
<img src='http://kuku.pe.kr/wordpress/wp-content/uploads/2017/10/IMG_0341-1024x576.jpg'>




# 4. 'KuKuTVNoti' working 

4-1) Using Thing tile buttons
<iframe width="560" height="315" src="https://youtu.be/CHAo5ffVQOw" frameborder="0" allowfullscreen></iframe>

4-2) Using CoRE(or any automation)
<iframe width="560" height="315" src="https://www.youtube.com/watch?v=IzeLuLSzFEA&feature=youtu.be" frameborder="0" allowfullscreen></iframe>


