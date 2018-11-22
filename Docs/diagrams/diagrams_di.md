# Проектирование системы (UML диаграммы)
### Содержание

 Глоссарий

1.  [Диаграмма вариантов использования](#1)<br>
    1.1.  [Актеры](#1.1)<br>
    1.2.  [Варианты использования](#1.2)<br>  
    1.2.1.  [Добавить файл](#1.2.1)<br>
    1.2.2.  [Удалить файл] (#1.2.2)<br>
    1.2.3.  [Открыть файл] (#1.2.3)<br>
    1.2.  [Варианты использования](#1.2)<br>  
    1.2.1.  [Добавить файл](#1.2.1)<br>
    1.2.2.  [Удалить файл](#1.212)<br>    
    1.2.3.  [Открыть файл](#1.2.3)<br> 
2.  [Диаграмма активностей](#2)<br>
3.  [Диаграмма последовательности](#3)<br>    
4.  [Диаграмма состояний](#4)<br>    
5.  [Диаграмма классов](#5)<br> 
6.  [Диаграмма компонентов](#6)<br>
    
## Глоссарий

# 1. Диаграмма вариантов использования <a name = "1"></a>
![usecase](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/UseCaseDiagram/UseCase.PNG)
  
# 1. Сценарии использования


## 1.1. Описание актеров <a name = "1.1"></a>

|Актер| Описание |
|--|--|
| Пользователь | Человек, который использует приложение |


## 1.2.  Диаграмма прецедентов <a name = "1.2"></a>
![UseCase](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/UseCaseDiagram/UseCase.PNG)
### 1.2.1. Add File

**Описание:**  Вариант использования "Add file" позволяет создать пользователю новый файл.

**Основной поток.**

1.  Пользователь нажимает кнопку "Add file".
2.  Приложение открывает для пользователя окно для ввода информации.
3.  Пользователь вводит указанные данные.
4.  Пользователь нажимает кнопку "Ok".
5.  Приложение добавляет введенные данные в бд.
6.  Вариант использования завершён.
    

### [](https://github.com/greadvx/tistic.co/blob/master/docs/system_design/System_design.md#222-access-to-medical-data-)1.2.2. Delete file


**Описание:**  Вариант использования "Delete file" позволяет удалить файл из бд.

**Основной поток.**

1.  Пользователь выбирает нужный файл.
2. Пользователь нажимает кнопку "Delete file".
4.  Пользователь нажимает кнопку "Ok".
5.  Приложение удаляет выбранный файл из бд.
6.  Вариант использования завершён.
    

### [](https://github.com/greadvx/tistic.co/blob/master/docs/system_design/System_design.md#223-add-medical-information-)1.2.3. Open file

**Описание:**  Вариант использования "Open file" позволяет удалить файл из бд.

**Основной поток.**

1.  Пользователь выбирает нужный файл.
2. Пользователь нажимает кнопку "Open".
4.  Пользователь нажимает кнопку "Ok".
5.  Приложение запускает выбранный файл по заданному пути.
6.  Вариант использования завершён.
    
# 2. Диаграмма активностей <a name = "2"></a>
## 2.1 Диаграмма добавления файла <a name = "2.1"></a>
![addfile](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/ActivitiesDiagrams/add_File.jpg)

## 2.2 Диаграмма удаления файла <a name = "2.2"></a>
![deletefile](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/ActivitiesDiagrams/delete_File.jpg)
## 2.3 Диаграмма открытия файла <a name = "2.3"></a>
![openfile](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/ActivitiesDiagrams/open_file.jpg)
# 3. Диаграммы последовательности <a name = "3"></a>
## 3.1 Добавление файла <a name = "3.1"></a>
![add](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/SequencesDiagrams/%D0%B7%D0%B0%D0%BF%D0%B8%D1%81%D0%B0%D1%82%D1%8C%20%D1%84%D0%B0%D0%B9%D0%BB%20%D0%B2%20%D0%B1%D0%B4.png)
## 3.2 Удаление файла<a name = "3.2"></a>
![del](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/SequencesDiagrams/%D0%A3%D0%B4%D0%B0%D0%BB%D0%B8%D1%82%D1%8C%20%D1%84%D0%B0%D0%B9%D0%BB%20%D0%B8%D0%B7%20%D0%B1%D0%B4.png)
## 3.3 Открытие файла <a name = "3.3"></a>
[![State](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/SequencesDiagrams/%D0%BE%D1%82%D0%BA%D1%80%D1%8B%D1%82%D1%8C%20%D1%84%D0%B0%D0%B9%D0%BB.png)](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/SequencesDiagrams/%D0%BE%D1%82%D0%BA%D1%80%D1%8B%D1%82%D1%8C%20%D1%84%D0%B0%D0%B9%D0%BB.png)
# 4. Диаграмма состояний <a name = "4"></a>

[![State](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/AddFile.JPG)](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/AddFile.JPG)
[![State](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/DeleteFile.JPG)](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/DeleteFile.JPG)
[![State](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/OpenFile.JPG)](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/StateDiagram/OpenFile.JPG)

# 5. Class Diagram <a name = "5"></a>
[![classDiagram](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/classDiagram/ClassDiagram.JPG)

# 6. Component and Deployment Diagram <a name = "6"></a>

[![Component_deployment](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/ComponentDiagram/ComponentDiagram.jpg)](https://github.com/catherine-yarosh-650501/BookerFiles/blob/master/Docs/diagrams/ComponentDiagram/ComponentDiagram.jpg)
