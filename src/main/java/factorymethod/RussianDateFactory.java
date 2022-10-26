package factorymethod;

/**
 * Фабрика российской даты.
 */
public class RussianDateFactory implements DateFactory {

  /**
   * Возвращает сущность российской даты.
   *
   * @return Российская дата.
   */
  @Override
  public Date createDate() {
    return new RussianDate();
  }
}
