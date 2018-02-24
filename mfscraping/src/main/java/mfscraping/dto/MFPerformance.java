package mfscraping.dto;

import java.util.Date;

public class MFPerformance {
		
		private final String mfid;
		private final String month_wise_performance;
		private final Date as_of;

		public MFPerformance(String mfid,String month_wise_performance,Date as_of) {
			this.mfid=mfid;
			this.month_wise_performance=month_wise_performance;
			this.as_of=as_of;
		}

		public String getMfid() {
			return mfid;
		}

		public String getMonth_wise_performance() {
			return month_wise_performance;
		}

		public Date getAs_of() {
			return as_of;
		}
}
