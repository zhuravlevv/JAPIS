%{

#include <stdio.h>

int yylex (void);
void yyerror (char const *);
  
%}
%union
{
	char *sval;
}

%token L
%token R
%token <sval> ID
%token <sval> NUM
%token <sval> PROCEDURE
%token SEMICOLON
%token COMMA

%start functions
%%

functions:			| functions function
					;
function:           ID L {printf("Procedure name: %s\n", $1);}
					full_params
					R
					SEMICOLON
 					;
full_params:		/* empty */
					| params identifier
					;
params:          	/* empty */
					| params param
					;
param:        		identifier COMMA
					;
identifier:			ID {printf("Identifier : %s\n", $1);}
					| NUM {printf("Roman numberic : %s\n", $1);}
					;
%%

void yyerror (char const *s)
{
	printf("Error: %s\n", s);
}


main (void) {
	while(1){
    	yyparse();
    }
    return 0;
}
