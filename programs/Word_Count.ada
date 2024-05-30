with ADA.TEXT_IO;
with ADA.INTEGER_TEXT_IO;

use ADA.TEXT_IO;
use ADA.INTEGER_TEXT_IO;

procedure P_WORD_COUNT is
    V_FILE    : FILE_TYPE;
    V_NAME    : STRING(1..80);
    V_SIZE    : NATURAL;
    V_COUNT   : NATURAL := 0;
    V_IN_WORD : BOOLEAN := FALSE;
    V_CHAR    : CHARACTER;
begin
    -- Open input file
    loop
        begin
            PUT ("Enter filename: ");
            GET_LINE (V_NAME, V_SIZE);
            OPEN (V_FILE, MODE => IN_FILE, NAME => V_NAME(1..V_SIZE));
            exit;
        exception
            when NAME_ERROR | USE_ERROR =>
                PUT_LINE ("Invalid filename -- please try again.");
        end;
    end loop;
    
    -- Process file
    while not END_OF_FILE (V_FILE) loop
        -- The end of a line is also the end of a word
        if END_OF_FILE (V_FILE) then
            V_IN_WORD := FALSE;
        end if;
    
        -- Process next character
        GET (V_FILE, V_CHAR);
        if V_IN_WORD and V_CHAR = ' ' then
            V_IN_WORD := FALSE;
        elsif not V_IN_WORD and V_CHAR /= ' ' then
            V_IN_WORD := TRUE;
            V_COUNT   := V_COUNT + 1;
        end if;
    end loop;
    
    -- Close file and display result
    CLOSE (V_FILE);
    PUT (V_COUNT);
    PUT_LINE (" words.");
end P_WORD_COUNT;