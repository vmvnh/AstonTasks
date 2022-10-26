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
}
