import com.fa.test.Bill;
import com.fa.test.Configuration;
import com.fa.test.ProductFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

public class PrintBillSteps {

    private Bill billToPrint = new Bill();
    private String displayedBill;

    @Given("(\\d+) (.*) à (\\d+.\\d+)")
    public void aProduct(int quantiy, String name, double price) throws Throwable {

        billToPrint.addProduct(new ProductFactory().create(quantiy, name, price));
    }

    @When("printing the bill")
    public void printingTheBill() throws Throwable {
        displayedBill = billToPrint.display(Configuration.displayer);
    }

    @Then("the printed bill have this rows:")
    public void printedLinesShouldBe(List<BillRow> rows) throws Throwable {

        final String expectedDisplayedBill = rows.stream().map(r->r.getRow()).collect(joining("\n"));

        System.out.print(expectedDisplayedBill);

        assertThat(billToPrint.display(Configuration.displayer)).isEqualTo(expectedDisplayedBill);
    }

    public class BillRow {
        private String row;

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }
    }
}
