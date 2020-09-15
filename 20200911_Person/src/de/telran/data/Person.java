package de.telran.data;

public class Person {
    private String name;
    private int age;
    private int height;

    //Конструктор
    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 110) {
            this.age = age;
        } else {
            System.out.println("Wrong age!");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0 && height < 230) {
            this.height = height;
        } else {
            System.out.println("Wrong height!");
        }
    }

/*    @Override//Это аннотация о том, что метод переписан
    public boolean equals(Object o) {
        if (this == o) return true;//Если ссылка в памяти указывает на одни и те же поля,
        // то объекты идентичны и дальше проверять не надо
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        return getName().equals(person.getName());
    }

    @Override
    //Фундаментальный метод класса Object, используется для генерации целочисленного кода объекта
    public int hashCode() {
        int result = getName().hashCode();
        result = (31 * result) + getAge();
        return result;
    }*/

    @Override
    public String toString() {
        return "Name: " + name +
                ", age " + age +
                ", height " + height + "\n";
    }

    public static void outPrint(Person[] array) {
        for (Person i : array) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void findOldestPerson(Person[] array) {
        //Сначала написала сама через count
/*        int count = 1;
        Person oldestPerson = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (oldestPerson.getAge() < array[count].getAge()) {
                oldestPerson = array[count];
            }
            count++;
        }*/
        // Потом увидела ваше решение в классе, оставляю его )
        Person oldestPerson = array[0];
        for (int i = 1; i < array.length; i++) {
            if (oldestPerson.getAge() < array[i].getAge()) {
                oldestPerson = array[i];
            }
        }
        System.out.println("The oldest person is " + oldestPerson.getName() + ", "
                + oldestPerson.getAge() + " years old. \n");
    }

    public static void findLongestNamePerson(Person[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].getName().length() > array[i + 1].getName().length()) {
                Person temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        System.out.println("A person with the longest name is " + array[array.length - 1].getName() + ", "
                + array[array.length - 1].getAge() + " years old. \n");
    }
    //Компаратор - метод сравнения двух людей по возрасту (двух объектов по полю возраст)
    //static - метод не зависит от объекта
    private static int comparePersonsAge(Person p1, Person p2){
        if (p1.age > p2.age){
            return 1;
        } else if (p1.age < p2.age) {
            return -1;
        } return 0;
    }

    //Теперь создадим не статичный компаратор для объектов
    private int comparePersonsByAge(Person p){
        if (this.age > p.age){
            return 1;
        } else if (this.age < p.age){
            return -1;
        } return 0;
    }

    //Теперь при помощи компаратора делаем сортировку bubblesort
    public static void sortPersonsByAge(Person[] array){
        System.out.println("Сортировка по возрасту по убыванию: ");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < (array.length - 1) - i; j++) {
                if (comparePersonsAge(array[j], array[j + 1]) < 0){
                    Person temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void sortPersonsByAge2(Person[] array){
        System.out.println("Сортировка по возрасту по возрастанию: ");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < (array.length - 1) - i; j++) {
                if (array[j].comparePersonsByAge(array[j + 1]) > 0){
                    Person temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void sortPersonsByNames(Person[] array){
        System.out.println("Сортировка по имени по возрастанию: ");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].name.compareTo(array[j + 1].name) > 0){
                    Person temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private int comparePersonsByHeight(Person p){
        if (this.height > p.height){
            return 1;
        } else if (this.height < p.height){
            return -1;
        } return 0;
    }

    public static void sortPersonsByHeight(Person[] array){
        System.out.println("Сортировка по весу по возрастанию: ");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < (array.length - 1) - i; j++) {
                if (array[j].comparePersonsByHeight(array[j + 1]) > 0){
                    Person temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void sortPersonsByHeight2(Person[] array){
        System.out.println("Сортировка по весу по убыванию: ");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < (array.length - 1) - i; j++) {
                if (array[j].comparePersonsByHeight(array[j + 1]) < 0){
                    Person temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
