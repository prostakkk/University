import 'package:task/task.dart' as task;
import 'dart:async';
class PizzaShop<T> {
  String _name;
  String _address;
  List<WorkDay> _workDays;

  PizzaShop(this._name, this._address, this._workDays);

  String get name => _name;
  set name(String value) => _name = value;

  String get address => _address;
  set address(String value) => _address = value;

  List<WorkDay> get workDays => _workDays;
  set workDays(List<WorkDay> value) => _workDays = value;

  double get averageOrdersPerDay {
    if (workDays.isEmpty) return 0;
    int totalOrders = 0;
    workDays.forEach((day) {
      totalOrders += day.orderCount;
    });
    return totalOrders / workDays.length;
  }

  List<WorkDay> findDaysWithMaxVisits() {
    if (workDays.isEmpty) return [];
    int maxVisits = workDays.map((day) => day.orderCount).reduce((a, b) => a > b ? a : b);
    return workDays.where((day) => day.orderCount == maxVisits).toList();
  }

  int getTotalOrdersForSpecialPizza(String specialPizza) {
    return workDays
        .where((day) => day.specialPizza == specialPizza)
        .map((day) => day.orderCount)
        .reduce((a, b) => a + b);
  }

  Future<T> fetchData() async {
    await Future.delayed(Duration(seconds: 2));

    T result = address as T;

    bool hasError = false; // true - щоб перевірити помилку

    if (hasError) {
      return Future.error("Помилка при отриманні даних");
    } else {

      return result;
    }
  }

}

class WorkDay {
  DateTime _date;
  int _orderCount;
  String _specialPizza;

  WorkDay(this._date, this._orderCount, this._specialPizza);

  DateTime get date => _date;
  set date(DateTime value) => _date = value;

  int get orderCount => _orderCount;
  set orderCount(int value) => _orderCount = value;

  String get specialPizza => _specialPizza;
  set specialPizza(String value) => _specialPizza = value;
}

void main() async {

  WorkDay day1 = WorkDay(DateTime(2023, 10, 27), 20, "Pepperoni");
  WorkDay day2 = WorkDay(DateTime(2023, 10, 28), 15, "Margherita");
  WorkDay day3 = WorkDay(DateTime(2023, 10, 29), 25, "Pepperoni");
  WorkDay day4 = WorkDay(DateTime(2023, 10, 30), 30, "Supreme");

  List<WorkDay> workDays = [day1, day2, day3, day4];

  PizzaShop pizzaShop = PizzaShop("SomeAdress", "SomeStreet", workDays);

  print("Середня кількість замовлень в день: ${pizzaShop.averageOrdersPerDay}");
  print("Дні з максимальним відвідуванням:");
  pizzaShop.findDaysWithMaxVisits().forEach((day) {
    print("Дата: ${day.date}, Замовлення: ${day.orderCount}");
  });
  String specialPizza = "Pepperoni";
  int totalOrders = pizzaShop.getTotalOrdersForSpecialPizza(specialPizza);
  print("Сумарна кількість замовлень для днів з піццою '$specialPizza': $totalOrders");
  await pizzaShop.fetchData().then((result) {
    if (result is String) {
      print("Адреса піцерії: $result");
    } else {
      print("Помилка: $result");
    }
  });
}
