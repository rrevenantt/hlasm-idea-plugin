grammar Test;

code:
    (statements| NANANA)* //EOF
    ;

statements:
    (LABEL? command)? SEMIC
    ;

command:
    GET arguments
    | PUT arguments
//    | NOP
    ;

arguments:
    arg (COMMA arg)*
    ;

arg :
    ID
    ;
LABEL : 'LABEL';
LEFT_PARN : '(';
RIGHT_PARN : ')';
COMMA: ',';
SEMIC: ';';
GET : 'GET';
PUT : 'PUT';
NOP : 'NOP';
NANANA : 'NANANA';
ID : [a-zA-Z0-9]+;
SPACE : [ \t\r\n]+ -> skip;
ERROR : . ;