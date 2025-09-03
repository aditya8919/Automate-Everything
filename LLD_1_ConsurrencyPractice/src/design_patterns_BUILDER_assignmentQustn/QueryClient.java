package design_patterns_BUILDER_assignmentQustn;

import design_patterns_BUILDER_assignmentQustn.Query.QueryBuilder;

public class QueryClient
{
	
	public static void main(String[] args)
	{
		Query qb= Query.getBuilder()
									.setFrom("")
									.setGroupBy("")
									.setJoin(null)
									.setOrderBy(null)
									.setSelect(null)
									.setWhere(null)
									.build();
		
		
		
		
		
	}

}
