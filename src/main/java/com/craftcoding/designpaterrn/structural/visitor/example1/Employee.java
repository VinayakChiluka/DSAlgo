package com.craftcoding.designpaterrn.structural.visitor.example1;

interface Employee {
    void accept(ReviewVisitor visitor);
}
interface ReviewVisitor {
    void visit(PermanentEmployee e);
    void visit(ContractEmployee e);
    void visit(InternEmployee e);

}

class PermanentEmployee implements  Employee {
    private String name;
    private String email;
    private String designation;

    public PermanentEmployee(String name, String email, String designation) {
        this.name = name;
        this.email = email;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public void accept(ReviewVisitor visitor) {
        visitor.visit(this);
    }
}

class ContractEmployee implements  Employee {
    private String name;
    private String email;
    private String designation;
    private String parentOrg;

    public ContractEmployee(String name, String email, String designation, String parentOrg) {
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.parentOrg = parentOrg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getParentOrg() {
        return parentOrg;
    }

    public void setParentOrg(String parentOrg) {
        this.parentOrg = parentOrg;
    }

    @Override
    public void accept(ReviewVisitor visitor) {
        visitor.visit(this);
    }
}

class InternEmployee implements  Employee {
    private String name;
    private String email;
    private String designation;
    private String collage;

    public InternEmployee(String name, String email, String designation, String collage) {
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.collage = collage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    @Override
    public void accept(ReviewVisitor visitor) {
        visitor.visit(this);
    }
}

class PerformanceReview implements ReviewVisitor{

    @Override
    public void visit(PermanentEmployee e) {
        System.out.println("Performance of permanence full time employee name - " + e.getName());
    }

    @Override
    public void visit(ContractEmployee e) {
        System.out.println("Performance of contract parent org name  - " + e.getParentOrg());

    }

    @Override
    public void visit(InternEmployee e) {
        System.out.println("Performance of intern name - " + e.getCollage());

    }
}

class GoalSettingReview implements ReviewVisitor {

    @Override
    public void visit(PermanentEmployee e) {
        System.out.println("Goal set by full-time employee - " + e.getName());
    }

    @Override
    public void visit(ContractEmployee e) {
        System.out.println("Goal set being by contract employee - " + e.getParentOrg());
    }

    @Override
    public void visit(InternEmployee e) {
        System.out.println("Goal set being for intern employee - " + e.getCollage());
    }
}
class HRManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new PermanentEmployee("Vinayak Chiluka", "chilukavinayak.p@gmail.com", "Team Lead"),
                new PermanentEmployee("Chintu", "chintu@gmail.com", "Sr Software Engineer"),
                new InternEmployee("Dibyani", "dbyan@gmail.com", "jr Enginer","MG Collage")
        };


        GoalSettingReview goalSettingReview = new GoalSettingReview();
        PerformanceReview performanceReview = new PerformanceReview();
        for(Employee e : employees){
            e.accept(performanceReview);
            e.accept(goalSettingReview);
        }

    }
}