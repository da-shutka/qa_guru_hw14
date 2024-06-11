# Проект по автоматизации тестирования для компании [<img width="10%" title="Bercut" src="media/icons/Bercut.svg"/>](https://bercut.com/)
>Более 28 лет Bercut выступает технологическим партнером компаний, встающих на путь цифровой трансформации. Команда Bercut — это сотни профессионалов в области высоких технологий, которые опираясь на опыт и экспертизу, поставляют на мировой рынок отраслевые программные решения, ориентированные на бизнес.

## :scroll: Содержание
- [Используемый стек](#computer-используемый-стек)
- [Автоматизированные тесты](#ballot_box_with_check-автоматизированные-тесты)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Allure-отчет](#-allure-отчет)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-тестов-в-selenoid)
  
## :computer: Используемый стек
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.svg"/></a> 
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/icons/Java.svg"/></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/icons/Selenide.svg"/></a> 
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/icons/Selenoid.svg"/></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/icons/Allure_Report.svg"/></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/icons/Gradle.svg"/></a> 
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/icons/JUnit5.svg"/></a> 
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/icons/GitHub.svg"/></a> 
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/icons/Jenkins.svg"/></a> 
<a href="https://telegram.org/"><img width="6%" title="Telegram" src="media/icons/Telegram.svg"/></a>  
</p>

Автотесты:
- Реализованы на языке ```Java```
- В качестве сборщика используется ```Gradle```
- Используются фреймворки ```JUnit 5``` и ```Selenide```
- При запуске тестов браузер запускается в ```Selenoid```
- Для удаленного запуска используется сборка в ```Jenkins```
- Для сборки формируется ```Allure Report```
- Результат отправляется в ```Telegram``` канал при помощи бота 

Allure-отчет:
* Шаги теста
* Скриншот страницы на последнем шаге
* Исходный код страницы
* Логи консоли браузера
* Видео выполнения теста

## :ballot_box_with_check: Автоматизированные тесты

- Проверка глобального поиска по всем ресурсам сайта
- Проверка страницы с контактами организации
- Проверка перехода на страницу продукта
- Проверка переключения каталогов
- Проверка поиска вакансий

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/icons/Jenkins.svg"> Сборка в Jenkins
[<img width="50%" title="Jenkins" src="media/img/Jenkins_Job.PNG"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit14/)

### *Параметры сборки в Jenkins:*
```TASK``` - название задачи (возможные варианты: ```bercut```)  
```WDHOST``` - адрес удаленного браузера (selenoid) (возможные варианты: ```selenoid.autotests.cloud```)  
```BROWSER``` - браузер для запуска тестов (по умолчанию - ```chrome```)  
```BROWSER_VERSION``` - версия браузера (по умолчанию - ```120```)  
```BROWSE_SIZE``` - размер окна браузера (по умолчанию - ```1920x1080```)  



### *Команды для запуска из терминала*


***Локальный запуск:***
```bash
gradle clean bercut
```
При выполнении данной команды в терминале IDE тесты запустятся удаленно в <code>Selenoid</code>.

***Запуск в Jenkins:***
```java
clean ${TASK}
-DwdHost=${WDHOST}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowseSize=${BROWSE_SIZE}
```

Для запуска сборки необходимо:
1. Перейти в сборку
2. Нажать ```Собрать с параметрами```/```Build with parameters```
3. Нажать ```Собрать```/```Build```

## <img width="4%" style="vertical-align:middle" title="Allure_Report" src="media/icons/Allure_Report.svg"> Allure-отчет
После выполнения сборки в блоке ```История сборок```/```Build History``` напротив конкретной сборки отображается значок 
[<img width="2%" title="IntelliJ IDEA" src="media/icons/Allure_Report.svg"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit14/allure/),
при нажатии на который открывается страница со сформированным html-отчетом и тестовой документацией.

### *Главная страница отчета* 
[<img width="50%" title="Allure Report" src="media/img/Allure_Report_Main.PNG"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit14/allure/)

### *Тест-кейсы*
[<img width="50%" title="Allure Report" src="media/img/Allure_Report_Suites.PNG"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit14/allure/#suites/2184bf7abab8d293fe47b00eaed1b94c/f9953d2919a8ac1e/)

### *Графики*
[<img width="50%" title="Allure Report" src="media/img/Allure_Report_Graphs.PNG"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit14/allure/#graph)



## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/icons/Telegram.svg"> Уведомления в Telegram
После завершения сборки специальный бот, созданный в ```Telegram```, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

[<img width="30%" title="Telegram Notifications" src="media/img/Telegram_Result.PNG">]()

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/icons/Selenoid.svg"> Видео примера запуска тестов в Selenoid

В Allure-отчетах к каждому тесту прикреплен не только скриншот, но и видео прохождения теста.  
Пример:

[<img width="30%" title="Test Run Gif" src="media/img/Test_run.gif">]()
