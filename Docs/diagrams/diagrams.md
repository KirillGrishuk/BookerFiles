# Проектирование системы (UML диаграммы)

Glossary

1.  Activity Diagram 
2.  Use Case Diagram
    2.1.  Actors
    2.2.  Use Cases  
    2.2.1.  User logon
    2.2.2.  Access to medical 
    2.2.3.  Add medical information 
    2.2.4.  Delete medical information(
    2.2.5.  Edit basic medical information
       
3.  Sequence Diagram    
4.  State Machine Diagram    
5.  Class Diagram 
6.  Component Diagram
    

# 1. Диаграмма активности

  ![Добавить файл](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/ActivitiesDiagrams/add_File.jpg)
![Удалить файл](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/ActivitiesDiagrams/delete_File.jpg)
![Открыть файл](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/ActivitiesDiagrams/open_file.jpg)
# 2. Сценарии использвания

![UseСase](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/UseCaseDiagram/UseCase.PNG)

## 2.1. Описание актеров

|Актер| Описание |
|--|--|
| Пользователь | Человек, который использует приложение |


## 2.2.  Диаграмма прецедентов 
![UseCase](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/UseCaseDiagram/UseCase.PNG)
### 2.2.1. Add File

**Описание:**  Вариант использования "Add file" позволяет создать пользователю новый файл.

**Основной поток.**

1.  Пользователь нажимает кнопку "Add file".
2.  Приложение открывает для пользователя окно для ввода информации.
3.  Пользователь вводит указанные данные.
4.  Пользователь нажимает кнопку "Ok".
5.  Приложение добавляет введенные данные в бд.
6.  Вариант использования завершён.
    

### [](https://github.com/greadvx/tistic.co/blob/master/docs/system_design/System_design.md#222-access-to-medical-data-)2.2.2. Delete file


**Описание:**  Вариант использования "Delete file" позволяет удалить файл из бд.

**Основной поток.**

1.  Пользователь выбирает нужный файл.
2. Пользователь нажимает кнопку "Delete file".
4.  Пользователь нажимает кнопку "Ok".
5.  Приложение удаляет выбранный файл из бд.
6.  Вариант использования завершён.
    

### [](https://github.com/greadvx/tistic.co/blob/master/docs/system_design/System_design.md#223-add-medical-information-)2.2.3. Open file

**Описание:**  Вариант использования "Open file" позволяет удалить файл из бд.

**Основной поток.**

1.  Пользователь выбирает нужный файл.
2. Пользователь нажимает кнопку "Open".
4.  Пользователь нажимает кнопку "Ok".
5.  Приложение запускает выбранный файл по заданному пути.
6.  Вариант использования завершён.
    

# 3. Диаграммы последовательности
## 3.1 Добавление файла
![add](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/SequencesDiagrams/%D0%B7%D0%B0%D0%BF%D0%B8%D1%81%D0%B0%D1%82%D1%8C%20%D1%84%D0%B0%D0%B9%D0%BB%20%D0%B2%20%D0%B1%D0%B4.png)
## 3.2 Удаление файла
![del](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/SequencesDiagrams/%D0%A3%D0%B4%D0%B0%D0%BB%D0%B8%D1%82%D1%8C%20%D1%84%D0%B0%D0%B9%D0%BB%20%D0%B8%D0%B7%20%D0%B1%D0%B4.png)
## 3.3 Открытие файла
[![State](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/SequencesDiagrams/%D0%BE%D1%82%D0%BA%D1%80%D1%8B%D1%82%D1%8C%20%D1%84%D0%B0%D0%B9%D0%BB.png)](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/SequencesDiagrams/%D0%BE%D1%82%D0%BA%D1%80%D1%8B%D1%82%D1%8C%20%D1%84%D0%B0%D0%B9%D0%BB.png)
# 4. Диаграмма состояний

[![State](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/AddFile.JPG)](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/AddFile.JPG)
[![State](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/DeleteFile.JPG)](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/DeleteFile.JPG)
[![State](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/OpenFile.JPG)](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/OpenFile.JPG)

# 5. Class Diagram

[![Class](https://github.com/greadvx/tistic.co/raw/master/docs/system_design/Class_diagram/Class_diagram.png)](https://github.com/greadvx/tistic.co/blob/master/docs/system_design/Class_diagram/Class_diagram.png)

# 6. Component and Deployment Diagram

[![Component_deployment](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/ComponentDiagram/ComponentDiagram.jpg)](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/ComponentDiagram/ComponentDiagram.jpg)
