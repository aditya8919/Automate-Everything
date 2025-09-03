package design_patterns_BUILDER_assignmentQustn;

public class Query 
{

   /*  private String select;
    private String from;
    private String where;
    private String join;
    private String orderBy;
    private String groupBy; */

    private Query(QueryBuilder q) {

    }


    public static QueryBuilder getBuilder()
    {
        return new QueryBuilder();
    }



    public static class QueryBuilder 
    {
    
        private String select;
        private String from;
        private String where;
        private String join;
        private String orderBy;
        private String groupBy;
    
        public QueryBuilder()
        {
        	
        }
    
    
        public String getSelect() {
            return select;
        }
    
        public QueryBuilder setSelect(String select) {
    
            this.select = select;
            return this;
        }
    
        public String getFrom() {
            return from;
        }
    
        public QueryBuilder setFrom(String from) {
    
            this.from = from;
            return this;
        }
    
    
        public String getWhere() {
            return where;
        }
    
        public QueryBuilder setWhere(String where) {
    
            this.where = where;
            return this;
        }
    
        public String getJoin() {
            return join;
        }
    
        
        public QueryBuilder setJoin(String join) {
    
            this.join = join;
            return this;
        }
    
        public String getOrderBy() {
            return orderBy;
        }
    
        public QueryBuilder setOrderBy(String orderBy) {
    
            this.orderBy = orderBy;
            return this;
        }
    
        public String getGroupBy() {
            return groupBy;
        }
    
        public QueryBuilder setGroupBy(String groupBy) {
    
            this.groupBy = groupBy;
            return this;
        }
    
        public Query build()
        {
            return new Query(this);
        }
    
    
    }




}

