/*
 * //somente testar métodos públicos
 * package br.univille.spring.boot.api.rest.service.proposal;
 *
 * import java.sql.Date;
 * import org.junit.Assert;
 * import org.junit.Test;
 * import br.univille.spring.boot.api.rest.model.Customer;
 * import br.univille.spring.boot.api.rest.model.Vehicle;
 * import br.univille.spring.boot.api.rest.service.proposal.calculation.
 * TotalLossCalculation;
 * import br.univille.spring.boot.api.rest.vo.ProposalVO;
 *
 * public class TotalLossCalculationTest {
 *
 * @Test
 * public void test1() {
 * Customer customer = Customer.builder().birthDate(new Date(2000-1900, 10,
 * 1)).build();
 * Vehicle vehicle = Vehicle.builder().assemblyYear(2014).price(10000).build();
 * ProposalVO proposal =
 * ProposalVO.builder().customer(customer).vehicle(vehicle).build();
 * TotalLossCalculation calculation = new TotalLossCalculation();
 *
 * float insurancePrice = calculation.calcute(proposal);
 *
 * Assert.assertEquals(500, insurancePrice, 0); //resultado esperado
 * }
 *
 * @Test
 * public void test3() {
 * Customer customer = Customer.builder().birthDate(new Date(1969-1900, 14,
 * 5)).build();
 * Vehicle vehicle = Vehicle.builder().assemblyYear(2014).price(80000).build();
 * ProposalVO proposal =
 * ProposalVO.builder().customer(customer).vehicle(vehicle).build();
 * TotalLossCalculation calculation = new TotalLossCalculation();
 *
 * float insurancePrice = calculation.calcute(proposal);
 *
 * Assert.assertEquals(800, insurancePrice, 0);
 * }
 *
 * @Test
 * public void test2() {
 * Customer customer = Customer.builder().birthDate(new Date(1984-1900, 14,
 * 5)).build();
 * Vehicle vehicle = Vehicle.builder().assemblyYear(2014).price(30000).build();
 * ProposalVO proposal =
 * ProposalVO.builder().customer(customer).vehicle(vehicle).build();
 * TotalLossCalculation calculation = new TotalLossCalculation();
 *
 * float insurancePrice = calculation.calcute(proposal);
 *
 * Assert.assertEquals(900, insurancePrice, 0);
 * }
 * }
 */
