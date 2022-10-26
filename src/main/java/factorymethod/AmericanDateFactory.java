package factorymethod;

/**
 * Фабрика американской даты.
 */
public class AmericanDateFactory implements DateFactory{
  /**
   * Возвращает сущность американской даты.
   *
   * @return Американская дата.
   */
  @Override
  public Date createDate() {
    return new AmericanDate();
  }

  // Переопределение метода для сравнения объектов.
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DateFactory that = (DateFactory) o;
    return this.createDate().getDate().equals(that.createDate().getDate());
  }
}
