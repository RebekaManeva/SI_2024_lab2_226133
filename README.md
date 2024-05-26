# SI_2024_lab2_226133

2.
![CFG](https://github.com/RebekaManeva/SI_2024_lab2_226133/assets/167009682/0376d696-db85-4dc5-9c02-7a827c05c389)

3. Цикломанска комплексност
Се пресметува со формулата E - V + 2 каде E e број на ребра, V е број на јазли.
34 - 26 + 2 = 10
Истото може да го добиеме со броењето на регионите на графот (повторно 10).

4. Every Branch критериум

Креираме листа items со 5 елементи. Во секој од тест примерите правиме по
мала промена со цел да се тестираат сите гранки.

items.add(new Item("oriz", "3333", 40, 0.2F));
items.add(new Item("mleko", "4444", 82, 0.1F));
items.add(new Item("leb", "5555", 43, 0.4F));
items.add(new Item("voda", "6666", 23, 0.01F));
items.add(new Item("kafe", "7777", 135, 0.8F));

Ова се оргиналните items.

 - @Test public void invalidNameTest()
На местото на mleko ставаме null, на местото на kafe ставаме празен string.
Со оваа функција проверуваме дали имињата на items со индекси 1 и 4 ќе бидат соодветни именувани во "unknown".

 - @Test public void emptyCart()
Листата ја иницијализираме на null и проверуваме дали ќе се фрли исклучокот дека листата е празна со соодветната порака.

 - @Test public void nullBarcodeTest()
На местото на "6666" баркодот поставуваме вредност null и проверуваме дали ќе биде фрлен точниот исклучок со соодветната порака.

 - @Test public void invalidBarcodeTest()
На местото на "5555" поставуваме "5$@55" со цел да видиме дали ќе биде фрлен исклучокот со соодветната порака за item со невалиден баркод.

 - @Test public void trueWithoutDiscount() и 
   @Test public void falseWithoutDiscount()
Ги поставуваме сите discounts на 0 и проверуваме дали според внесениот price ќе се испечатат соодветно true и false.

 - @Test public void returnTrueTest() и
   @Test public void returnFalseTest()
Ги поставуваме сите вредности како оригиналните и според внесениот price проверуваме дали соодветно ќе се испечатат true и false.

5. Multiple Condition критериум

- @Test public void priceMoreThan300()
- @Test public void discountLessOrEqualToZero()
- @Test public void barcodeStartsWithZero()
- @Test public void allConditionsMet()

Првите 3 тест функции ги задоволуваат сите услови освен еден според кој се и именувани. Со соодветните вредности и доделениот price, треба да испечатат false.
Последната функција ги задоволува сите три услови, што значи дека ќе се изврши кодот во if-от и соодветно ќе испечати true.

