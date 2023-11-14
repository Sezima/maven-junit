package models;

public class Claim {
    //coverage_type | claim_id | amount | date       | description         | supporting_documents
    private String claimID;
    private double amount;
    private String date;
    private String description;
    private String supportingDocuments;

    public Claim( String claimID, double amount, String date, String description, String supportingDocuments) {
        this.claimID = claimID;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.supportingDocuments = supportingDocuments;
    }

    public String getClaimID() {
        return claimID;
    }

    public void setClaimID(String claimID) {
        this.claimID = claimID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(String supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }
}
