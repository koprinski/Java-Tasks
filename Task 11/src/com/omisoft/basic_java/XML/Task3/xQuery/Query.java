package com.omisoft.basic_java.XML.Task3.xQuery;

/**
 * Query with the xQuery operations kept in strings
 * @author bkoprinski
 *
 */
public class Query {
    public static final String SORT_BY_YEAR = "for $x in doc('books.xml')//book order by $x/year return $x/title/text()"; // ex3
    public static final String AVG_PRICE = "let $x := doc('books.xml')//book return avg($x/price)"; // ex4
    public static final String NAME_COUNT_AUTHORS = "for $x in doc('books.xml')//book let $y := count($x/author) where $x/price>30  return ($x/title,<author>{$y}</author>)"; // ex5
    public static final String CHILD_TITLE_LETTER_CASE = "for $x in doc('books.xml')//book  return	if ($x/@category=\"CHILDREN\") then <child>{upper-case($x/title)}</child> else <adult>{lower-case($x/title)}</adult>"; // ex6
    public static final String DISCOUNT_BOOK_TITLES = "for $x in doc('books.xml')//book let $y := $x/price*0.1  return if($x/year>2003) then ($x/title,(<price>{($x/price)-$y}</price>)) else ($x/title,(<price>10</price>))"; // ex7
}
