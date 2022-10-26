package factorymethod;

public class FactoryMethodRun {

  /**
   * Работает с Фабричным методом.
   */
  public static void main(String[] args) {

    // Создание объекта фабрики даты.
    DateFactory dateFactory = createDateByCountry("russia");

    // Создание объекта даты.
    Date date = dateFactory.createDate();

    // Вывод даты в консоль
    System.out.println("Актуальная дата: " + date.getDate());
  }

  /**
   * Проверяет параметр, содержащий страну и вызывает соответствующую фабрику.
   *
   * @param param Название страны.
   * @return Фабрика даты.
   */
  static DateFactory createDateByCountry(String param) {

    // Проверяет какой стране соответствует параметр
    switch (param) {
      case ("russia"):
        return new RussianDateFactory();

      case ("america"):
        return new AmericanDateFactory();
    }

    // Если страна не определена, выводит исключение
    throw new RuntimeException(param + " country don't found");
  }
}
