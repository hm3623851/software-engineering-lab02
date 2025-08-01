# پیام رسان قزمیت :)

این یک برنامه خیلی کوچکی است که هر دوست عزیزی با هر سوادی (حتی سواد اول دبستان .. خخخ) می‌تواند بنویسد. ما قصد داریم این برنامه را به منظور یادگیری اصول شی گرایی به صورت عملی در اختیار دانشجویان عزیز و فرهیخته ای که در دانشکده مهندسی کامپیوتر و در بهار 1403 درس آز مهندسی نرم افزار را اخذ کرده اند قرار دهیم تا آن را اصلاح کنند.

## جدول تغییرات اعمال شده در مرحله اول


| ردیف | محل اعمال تغییرات | کلاس/واسط        | عنوان تغییر                      | شرحی کوتاه از تغییر                                                                                                             |
| -------- | -------------------------------- | ------------------------ | ------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------- |
| 1        | `src/edu/sharif/selab/models/`   | `TelegramMessage`        | ایجاد کلاس جدید               | ایجاد کلاس`TelegramMessage` که از `Message` ارث‌بری می‌کند و شامل فیلدهای `sourceId` و `targetId` است |
| 2        | `src/edu/sharif/selab/services/` | `MessageService`         | افزودن متد جدید               | افزودن متد`sendTelegramMessage(TelegramMessage telegramMessage)` به واسط                                                         |
| 3        | `src/edu/sharif/selab/services/` | `MessageService`         | افزودن import                        | افزودن`import edu.sharif.selab.models.TelegramMessage;`                                                                                   |
| 4        | `src/edu/sharif/selab/services/` | `EmailMessageService`    | پیاده‌سازی متد جدید       | پیاده‌سازی متد`sendTelegramMessage` با بدنه خالی                                                                         |
| 5        | `src/edu/sharif/selab/services/` | `EmailMessageService`    | افزودن import                        | افزودن`import edu.sharif.selab.models.TelegramMessage;`                                                                                   |
| 6        | `src/edu/sharif/selab/services/` | `SmsMessageService`      | پیاده‌سازی متد جدید       | پیاده‌سازی متد`sendTelegramMessage` با بدنه خالی                                                                         |
| 7        | `src/edu/sharif/selab/services/` | `SmsMessageService`      | افزودن import                        | افزودن`import edu.sharif.selab.models.TelegramMessage;`                                                                                   |
| 8        | `src/edu/sharif/selab/services/` | `TelegramMessageService` | ایجاد کلاس جدید               | ایجاد کلاس`TelegramMessageService` که `MessageService` را پیاده‌سازی می‌کند                                        |
| 9        | `src/edu/sharif/selab/services/` | `TelegramMessageService` | پیاده‌سازی متد اصلی       | پیاده‌سازی متد`sendTelegramMessage` با منطق ارسال و اعتبارسنجی                                               |
| 10       | `src/edu/sharif/selab/services/` | `TelegramMessageService` | افزودن متد اعتبارسنجی   | ایجاد متد`validateTelegramId` برای بررسی صحت آیدی تلگرام                                                          |
| 11       | `src/edu/sharif/selab/services/` | `TelegramMessageService` | پیاده‌سازی متدهای خالی | پیاده‌سازی`sendSmsMessage` و `sendEmailMessage` با بدنه خالی                                                               |
| 12       | `src/`                           | `Main`                   | افزودن import جدید               | افزودن import برای`TelegramMessage` و `TelegramMessageService`                                                                       |
| 13       | `src/`                           | `Main`                   | افزودن گزینه منو             | افزودن گزینه شماره 3 برای ارسال پیام تلگرام                                                                  |
| 14       | `src/`                           | `Main`                   | افزودن case جدید                 | افزودن`case 3` در switch برای مدیریت ورودی تلگرام                                                                  |
| 15       | `src/`                           | `Main`                   | افزودن شرط جدید               | افزودن شرط`instanceof TelegramMessage` در منطق ارسال                                                                        |
| 16       | `src/`                           | `Main`                   | تصحیح متن راهنما             | تصحیح متن راهنما از "Enter source phone" به "Enter source email" در بخش ایمیل                                       |

## خلاصه تعداد تغییرات

**مجموع تغییرات: 16 تغییر**

### تقسیم‌بندی تغییرات بر اساس نوع:

1. **ایجاد کلاس/فایل جدید: 2 مورد**

   - `TelegramMessage.java`
   - `TelegramMessageService.java`
2. **تغییر در واسط موجود: 2 مورد**

   - افزودن متد جدید به `MessageService`
   - افزودن import جدید به `MessageService`
3. **تغییر در کلاس‌های موجود: 10 مورد**

   - تغییرات در `EmailMessageService` (2 مورد)
   - تغییرات در `SmsMessageService` (2 مورد)
   - تغییرات در `Main` (6 مورد)
4. **پیاده‌سازی متدهای جدید: 2 مورد**

   - متد اصلی `sendTelegramMessage`
   - متد کمکی `validateTelegramId`

### تحلیل اثرات:

- **فایل‌های تغییر یافته: 6 فایل** (از مجموع فایل‌های موجود)
- **فایل‌های جدید ایجاد شده: 2 فایل**
- **تعداد کل فایل‌های دخیل در تغییرات: 8 فایل**

این تغییرات نشان می‌دهد که برای افزودن یک نوع پیام جدید، نیاز به تغییرات گسترده‌ای در سراسر پروژه داریم که این موضوع نشان‌دهنده عدم رعایت اصول SOLID در طراحی اولیه است.

## تحلیل اصول SOLID

### موارد تحقق اصول SOLID:

#### 1. Open/Closed Principle (OCP) - موارد تحقق:

- **کلاس‌های مدل**: کلاس‌های `EmailMessage`، `SmsMessage` و `TelegramMessage` به درستی از `Message` ارث‌بری می‌کنند و بدون تغییر کلاس پایه، قابلیت‌های جدید اضافه شده‌اند.

#### 2. Liskov Substitution Principle (LSP) - موارد تحقق:

- **جایگزینی کلاس‌های مدل**: تمام کلاس‌های پیام (`EmailMessage`, `SmsMessage`, `TelegramMessage`) می‌توانند به‌جای کلاس پایه `Message` استفاده شوند بدون اینکه رفتار برنامه خراب شود.
- **جایگزینی سرویس‌ها**: تمام کلاس‌های سرویس می‌توانند به‌جای `MessageService` interface استفاده شوند.

#### 3. Dependency Inversion Principle (DIP) - موارد تحقق:

- **استفاده از Interface**: کلاس `Main` به `MessageService` interface وابسته است، نه به پیاده‌سازی‌های مشخص.

#### 4. Single Responsibility Principle (SRP) - موارد تحقق:

- **کلاس‌های مدل**: هر کلاس پیام (`EmailMessage`, `SmsMessage`, `TelegramMessage`) تنها مسئولیت نگهداری اطلاعات یک نوع پیام خاص را دارد.
- **کلاس‌های سرویس**: هر سرویس در تئوری مسئولیت ارسال یک نوع پیام خاص را دارد.

#### 5. Interface Segregation Principle (ISP) - موارد تحقق:

- **کلاس‌های مدل**: کلاس‌های پیام interface‌های کوچک و مشخص دارند (getter/setter methods)

### موارد نقض اصول SOLID:

#### 1. Open/Closed Principle (OCP) - موارد نقض:

- **واسط MessageService**: برای افزودن `TelegramMessage`، مجبور به تغییر واسط `MessageService` شدیم (افزودن متد `sendTelegramMessage`)
- **کلاس‌های سرویس موجود**: `EmailMessageService` و `SmsMessageService` مجبور به پیاده‌سازی متد جدید شدند
- **کلاس Main**: برای پشتیبانی از نوع پیام جدید، نیاز به تغییرات متعددی در `Main` داشتیم

#### 2. Interface Segregation Principle (ISP) - موارد نقض:

- **واسط MessageService**: این واسط شامل متدهایی است که همه کلاس‌ها نیاز ندارند:
  - `EmailMessageService` مجبور به پیاده‌سازی `sendSmsMessage` و `sendTelegramMessage` است
  - `SmsMessageService` مجبور به پیاده‌سازی `sendEmailMessage` و `sendTelegramMessage` است
  - `TelegramMessageService` مجبور به پیاده‌سازی `sendSmsMessage` و `sendEmailMessage` است
- **کلاس‌ها به interface‌هایی وابسته‌اند که استفاده نمی‌کنند**

#### 3. Dependency Inversion Principle (DIP) - موارد نقض:

- **کلاس Main**: با وجود استفاده از interface، `Main` هنوز به کلاس‌های مشخص وابسته است:
  - `instanceof` checks برای تشخیص نوع پیام
  - ایجاد مستقیم نمونه‌هایی از `EmailMessageService`، `SmsMessageService`، `TelegramMessageService`
- **عدم استفاده از Dependency Injection**: سرویس‌ها به‌صورت مستقیم در `Main` ایجاد می‌شوند

#### 4. Single Responsibility Principle (SRP) - موارد نقض:

- **کلاس Main**: این کلاس چندین مسئولیت دارد:
  - مدیریت رابط کاربری (UI) و ورودی‌های کاربر
  - منطق تشخیص نوع پیام (`instanceof` checks)
  - ایجاد و مدیریت سرویس‌های پیام
  - کنترل جریان برنامه (loop management)
- **کلاس‌های سرویس**: هر سرویس مجبور به پیاده‌سازی متدهای غیرمرتبط است که مسئولیت‌های اضافی ایجاد می‌کند

#### 5. Liskov Substitution Principle (LSP) - موارد نقض:

- **کلاس‌های سرویس**: اگرچه همه از `MessageService` ارث‌بری می‌کنند، اما:
  - هر سرویس تنها یکی از متدها را به‌درستی پیاده‌سازی می‌کند
  - متدهای دیگر با بدنه خالی یا رفتار نامناسب پیاده‌سازی شده‌اند
  - جایگزینی یک سرویس با دیگری نمی‌تواند همان رفتار مورد انتظار را ارائه دهد

### نتیجه‌گیری:

طراحی فعلی نقض جدی اصول SOLID را نشان می‌دهد. برای افزودن یک نوع پیام جدید، نیاز به تغییر 6 فایل موجود داریم که این موضوع نشان‌دهنده عدم انعطاف‌پذیری و قابلیت توسعه‌پذیری ضعیف سیستم است.

## راه‌حل‌های پیشنهادی برای برقراری اصول SOLID


| اصل نقض شده                      | علت نقض                                                                                                                        | راه‌حل پیشنهادی                                                                                           | توضیحات پیاده‌سازی                                                                                                                                       |
| ----------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Open/Closed Principle (OCP)**           | تغییر واسط`MessageService` و کلاس‌های موجود برای افزودن نوع پیام جدید                    | ایجاد واسط عمومی`MessageSender` با متد واحد `send(Message message)`                              | هر سرویس تنها یک متد`send` پیاده‌سازی می‌کند و از طریق Factory Pattern یا Strategy Pattern انتخاب می‌شود             |
| **Interface Segregation Principle (ISP)** | واسط`MessageService` حاوی متدهایی که همه کلاس‌ها نیاز ندارند                                    | تقسیم واسط به چندین واسط کوچک:`SmsMessageSender`, `EmailMessageSender`, `TelegramMessageSender` | هر سرویس تنها واسط مرتبط با خودش را پیاده‌سازی می‌کند                                                                         |
| **Dependency Inversion Principle (DIP)**  | کلاس`Main` به کلاس‌های مشخص وابسته است و از Dependency Injection استفاده نمی‌کند         | استفاده از Factory Pattern یا Service Locator Pattern برای ایجاد سرویس‌ها                   | ایجاد`MessageSenderFactory` که بر اساس نوع پیام، سرویس مناسب را برمی‌گرداند                                                   |
| **Single Responsibility Principle (SRP)** | کلاس`Main` چندین مسئولیت دارد: UI، منطق تشخیص، مدیریت سرویس‌ها                          | تقسیم`Main` به کلاس‌های جداگانه: `UserInterface`, `MessageProcessor`, `ServiceManager`            | -`UserInterface`: مدیریت ورودی/خروجی<br/>- `MessageProcessor`: پردازش منطق پیام‌ها<br/>- `ServiceManager`: مدیریت سرویس‌ها |
| **Liskov Substitution Principle (LSP)**   | سرویس‌ها تنها یک متد را درست پیاده‌سازی می‌کنند و متدهای دیگر خالی هستند | حذف متدهای خالی و استفاده از واسط مشترک با متد عمومی                          | همه سرویس‌ها واسط`MessageSender` با متد `send(Message message)` را پیاده‌سازی می‌کنند                                              |

### طراحی پیشنهادی جدید:

#### 1. ساختار واسط‌ها:

```java
// واسط اصلی برای ارسال پیام
interface MessageSender {
    void send(Message message);
    boolean canHandle(Message message);
}

// واسط‌های اختصاصی (در صورت نیاز)
interface SmsMessageSender extends MessageSender {
    void sendSms(SmsMessage message);
}

interface EmailMessageSender extends MessageSender {
    void sendEmail(EmailMessage message);
}
```

#### 2. ایجاد Factory Pattern:

```java
class MessageSenderFactory {
    private static final List<MessageSender> senders = Arrays.asList(
        new SmsMessageService(),
        new EmailMessageService(),
        new TelegramMessageService()
    );

    public static MessageSender getSender(Message message) {
        return senders.stream()
            .filter(sender -> sender.canHandle(message))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No sender found"));
    }
}
```

#### 3. تقسیم مسئولیت‌های Main:

```java
class UserInterface {
    public Message getMessageFromUser() { /* UI logic */ }
}

class MessageProcessor {
    public void processMessage(Message message) {
        MessageSender sender = MessageSenderFactory.getSender(message);
        sender.send(message);
    }
}
```

### مزایای طراحی جدید:

- **قابلیت توسعه**: افزودن نوع پیام جدید بدون تغییر کد موجود
-
- **مسئولیت‌های مجزا**: هر کلاس یک مسئولیت واحد دارد
- **انعطاف‌پذیری**: امکان تغییر استراتژی ارسال در زمان اجرا
- **تست‌پذیری**: امکان Mock کردن آسان سرویس‌ها
- **نگهداری آسان**: تغییرات محلی بدون تأثیر بر سایر قسمت‌ها
