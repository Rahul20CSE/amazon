# 🛒 Amazon Test Automation Framework

This is a Selenium-based automation framework created to test the **Search** and **Add to Cart** functionalities on [Amazon India](https://www.amazon.in/), as part of a SpurQLabs QA assignment.

## ✅ Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

## 🚀 Features Implemented

- Invalid product search with "No results found"
- Valid product search (e.g., "Laptop")
- Clicking the 4th product in search results
- Adding the product to cart and verifying it

## 🔧 Setup Instructions

1. Clone the repo  
   `git clone https://github.com/Rahul20CSE/amazonTestCase.git`

2. Open in Eclipse/IntelliJ and run `mvn install`

3. Update `Configure.properties`:
   ```properties
   browser=chrome
   url=https://www.amazon.in/
   Valid=Laptop
   InvalidProd=invalidproduct123



amazonTestCase/
├── src/
│   ├── main/java/com/crm/
│   └── test/java/TestCase/
├── testng.xml
├── Configure.properties
└── README.md




---

#### 🔹 **Step 2: Save the file**
- Save the file as:  
  📄 `README.md`  
  inside:  
  `C:\Users\Asus\Desktop\code rahul\Selenium\amazon`

---

#### 🔹 **Step 3: Run Git Commands Again in Git Bash**

```bash
cd "C:/Users/Asus/Desktop/code rahul/Selenium/amazon"
git add README.md
git commit -m "Added README.md"
git push origin main


   

   
