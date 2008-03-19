package org.mifos.framework.components.batchjobs.helpers;

import java.math.BigDecimal;
import java.util.Set;

import org.apache.commons.collections.Predicate;
import org.mifos.application.branchreport.BranchReportBO;
import org.mifos.application.branchreport.BranchReportBOFixture;
import org.mifos.application.branchreport.BranchReportClientSummaryBO;
import org.mifos.application.branchreport.helper.BranchReportClientSummaryBatchBOExtractor;
import org.mifos.application.customer.business.service.CustomerBusinessService;
import org.mifos.application.office.business.OfficeBO;
import org.mifos.application.office.business.OfficecFixture;
import org.mifos.application.reports.business.service.BranchReportConfigService;
import org.mifos.application.reports.business.service.BranchReportService;
import org.mifos.application.reports.business.service.IBranchReportService;
import org.mifos.framework.MifosTestCase;
import org.mifos.framework.exceptions.PersistenceException;
import org.mifos.framework.exceptions.ServiceException;
import org.mifos.framework.util.helpers.DateUtils;
import org.springframework.core.io.Resource;

public class BranchReportClientSummaryHelperTest extends MifosTestCase {
	private static final Short THREE_SHORT = Short.valueOf("3");
	private static final String ONE_STRING = "1";
	private static final Integer ONE = new Integer(1);
	private static final Integer TEN = new Integer(10);
	private static final Integer FIVE = Integer.valueOf(5);
	public static final Short BRANCH_ID = THREE_SHORT;

	public void testPopulatesClientSummary() throws Exception {
		BranchReportBO branchReport = BranchReportBOFixture.createBranchReport(
				Integer.valueOf(1), BRANCH_ID, DateUtils.currentDate());
		new BranchReportClientSummaryHelper(OfficecFixture
				.createOffice(BRANCH_ID), branchReport,
				getCustomerBusinessServiceStub(), getBranchReportServiceStub(),
				getBranchReportConfigServiceStub()).populateClientSummary();
		assertClientSummary(branchReport);
	}

	private void assertClientSummary(BranchReportBO branchReport)
			throws PersistenceException {
		assertNotNull(branchReport.getBranchReportId());
		Set<BranchReportClientSummaryBO> branchReportClientSummaries = branchReport
				.getClientSummaries();
		assertNotNull(branchReportClientSummaries);
		assertEquals(12, branchReportClientSummaries.size());

		Predicate predicate = new BranchReportClientSummaryBatchBOExtractor()
				.matchAllPredicates(branchReportClientSummaries);
		assertNull(predicate + " not found in summaries", predicate);
	}

	private IBranchReportService getBranchReportServiceStub() {
		return new BranchReportService() {
			@Override
			public BigDecimal extractPortfolioAtRiskForOffice(OfficeBO office,
					Integer daysInArrears) throws ServiceException {
				return BigDecimal.ONE;
			}
		};
	}

	private BranchReportConfigService getBranchReportConfigServiceStub() {
		return new BranchReportConfigService(null) {
			@Override
			protected void initConfig(Resource configResource) {
			}

			@Override
			public Integer getGracePeriodDays() {
				return ONE;
			}

			@Override
			public Integer getLoanCyclePeriod() {
				return TEN;
			}
			
			@Override
			public Short getReplacementFieldId() throws ServiceException {
				return THREE_SHORT;
			}
			
			@Override
			public String getReplacementFieldValue() throws ServiceException {
				return ONE_STRING;
			}
		};
	}

	private CustomerBusinessService getCustomerBusinessServiceStub() {
		return new CustomerBusinessService() {

			@Override
			public Integer getActiveBorrowersCountForOffice(OfficeBO office)
					throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getActiveClientCountForOffice(OfficeBO office)
					throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getActiveSaversCountForOffice(OfficeBO office)
					throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getCustomerReplacementsCountForOffice(OfficeBO office, Short fieldId, String fieldValue)
					throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getCustomerVeryPoorReplacementsCountForOffice(
					OfficeBO office, Short fieldId, String fieldValue) throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getDropOutClientsCountForOffice(OfficeBO office)
					throws ServiceException {
				return ONE;
			}

			@Override
			public BigDecimal getClientDropOutRateForOffice(OfficeBO office)
					throws ServiceException {
				return BigDecimal.valueOf(1.34);
			}

			@Override
			public Integer getGroupCountForOffice(OfficeBO office)
					throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getOnHoldClientsCountForOffice(OfficeBO office)
					throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getVeryPoorActiveBorrowersCountForOffice(
					OfficeBO office) throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getVeryPoorActiveSaversCountForOffice(OfficeBO office)
					throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getVeryPoorClientCountForOffice(OfficeBO office)
					throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getVeryPoorDropOutClientsCountForOffice(
					OfficeBO office) throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getVeryPoorOnHoldClientsCountForOffice(
					OfficeBO office) throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getCenterCountForOffice(OfficeBO office)
					throws ServiceException {
				return ONE;
			}

			@Override
			public Integer getDormantClientsCountByLoanAccountForOffice(
					OfficeBO office, Integer loanCyclePeriod)
					throws ServiceException {
				return TEN;
			}

			@Override
			public Integer getVeryPoorDormantClientsCountByLoanAccountForOffice(
					OfficeBO office, Integer loanCyclePeriod)
					throws ServiceException {
				return FIVE;
			}

			@Override
			public BigDecimal getVeryPoorClientDropoutRateForOffice(
					OfficeBO office) throws ServiceException {
				return BigDecimal.TEN;
			}

			@Override
			public Integer getVeryPoorDormantClientsCountBySavingAccountForOffice(
					OfficeBO office, Integer loanCyclePeriod)
					throws ServiceException {
				return FIVE;
			}

			@Override
			public Integer getDormantClientsCountBySavingAccountForOffice(
					OfficeBO office, Integer loanCyclePeriod)
					throws ServiceException {
				return TEN;
			}
		};
	}
}
