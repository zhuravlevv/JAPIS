%{

#include <stdio.h>

int yylex (void);
void yyerror (char const *);
  
%}

%token ID
%token INT

%%
program: num_literal identifier
;
identifier: ID
;
num_literal : INT
;
%%

void yyerror (char const *s)
{
  fprintf (stderr, "%s\n", s);
}


main (void) {
	printf("Here\n");
    return yyparse();
}
