package com.example.messylife;

class Member {
    private String fullName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
    private String email;
    private String phoneNumber;
    private String permanentAddress;
    private String bloodGroup;
    private String Age;
    private int deposit;
    private int mealCount;
    private int expenses;


    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }




    public int getMealCount() {
        return mealCount;
    }

    public void setMealCount(int mealCount) {
        this.mealCount = mealCount;
    }



    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }




    public Member() {}

    public Member(String fullName, String email, String phoneNumber,String permanentAddress,String bloodGroup,String Age,String userName) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.Age =Age;
        this.permanentAddress = permanentAddress;
        this.bloodGroup = bloodGroup;
        this.mealCount = 0;
        this.deposit = 0;
        this.expenses = 0;
        this.userName = userName;

    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
    public String toString(){
        return this.userName;
    }

   // public int getTheMeal(){return this.mealCount;};
}