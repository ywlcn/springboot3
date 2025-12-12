

https://container-registry.oracle.com/ords/f?p=113:4:116540161899343:::4:P4_REPOSITORY,AI_REPOSITORY,AI_REPOSITORY_NAME,P4_REPOSITORY_NAME,P4_EULA_ID,P4_BUSINESS_AREA_ID:2223,2223,Oracle%20Autonomous%20Database%20Free,Oracle%20Autonomous%20Database%20Free,1,0&cs=3MGLqi_hS_lVT-QEGQJLRVdV_G3T9i3l80Yq7AlSr8pUiXLdLDspYjZ3e3faNEKn-xN7VaVq3coqsXSi2Y97Vug


sudo keytool -import -alias adb_container_certificate -file adb_container.cert -keystore  /Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/lib/security/cacerts


docker pull container-registry.oracle.com/database/adb-free:latest-23ai

https://container-registry.oracle.com/

# ログイン

https://localhost:8443/ords/sql-developer

https://192.168.10.128:8443/ords/sql-developer

ADMIN/Welcome_1234
owx/Welcome_1234                                 122.26.124.2

https://qiita.com/nisshii0/items/e300edbbb7845a40cc11

Listener Parameter File   /u01/app/oracle/product/23.0.0.0/dbhome_1/network/admin/listener.ora
Listener Log File         /u01/app/oracle/diag/tnslsnr/8d8efb51f8dd/listener/alert/log.xml

```bash
podman run -d \
-p 1521:1522 \
-p 1522:1522 \
-p 8443:8443 \
-p 27017:27017 \
-e WORKLOAD_TYPE=ATP \
-e WALLET_PASSWORD=Welcome_1234 \
-e ADMIN_PASSWORD=Welcome_1234 \
--cap-add SYS_ADMIN \
--device /dev/fuse \
--name adb-free \
container-registry.oracle.com/database/adb-free:latest-23ai
```

```
podman logs adb-free
Archive:  /u01/POD1.zip
   creating: /u01/app/oracle/oradata/
   creating: /u01/app/oracle/oradata/POD1/
  inflating: /u01/app/oracle/oradata/POD1/redo01.log
   creating: /u01/app/oracle/oradata/POD1/4013D22CB9255901E0636402000AD212/
   creating: /u01/app/oracle/oradata/POD1/4013D22CB9255901E0636402000AD212/datafile/
   creating: /u01/app/oracle/oradata/POD1/4013D046FEB85839E0636402000A1853/
   creating: /u01/app/oracle/oradata/POD1/4013D046FEB85839E0636402000A1853/datafile/
  inflating: /u01/app/oracle/oradata/POD1/redo02.log
   creating: /u01/app/oracle/oradata/POD1/4013CA5992D354CBE0636402000A9FF7/
   creating: /u01/app/oracle/oradata/POD1/4013CA5992D354CBE0636402000A9FF7/datafile/
   creating: /u01/app/oracle/oradata/POD1/datafile/
  inflating: /u01/app/oracle/oradata/POD1/datafile/o1_mf_data_nfskm9n4_.dbf
  inflating: /u01/app/oracle/oradata/POD1/datafile/o1_mf_temp_nfskxpz7_.tmp
  inflating: /u01/app/oracle/oradata/POD1/datafile/o1_mf_sysaux_nfsjx92x_.dbf
  inflating: /u01/app/oracle/oradata/POD1/datafile/o1_mf_system_nfsjsjs1_.dbf
  inflating: /u01/app/oracle/oradata/POD1/datafile/o1_mf_undotbs1_nfskxoqf_.dbf
   creating: /u01/app/oracle/oradata/POD1/onlinelog/
   creating: /u01/app/oracle/oradata/POD1/3F84CEBE12E97585E0639FD25E64D9C3/
   creating: /u01/app/oracle/oradata/POD1/3F84CEBE12E97585E0639FD25E64D9C3/datafile/
   creating: /u01/app/oracle/oradata/POD1/3F8644B66B390B8BE0639FD25E643D30/
   creating: /u01/app/oracle/oradata/POD1/3F8644B66B390B8BE0639FD25E643D30/datafile/
   creating: /u01/app/oracle/oradata/POD1/controlfile/
  inflating: /u01/app/oracle/oradata/POD1/controlfile/o1_mf_nfsk7vdq_.ctl
TIME ELAPSED Unzipping /u01/POD1.zip: 0 minutes and 21 seconds elapsed
User input JSON not found
MY ADB WORKLOAD_TYPE is ATP
MY ADB CUSTOM NAME is MYATP
BUILDER: Configuring TCPS
BUILDER: Cleanup /u01/app/oracle/wallets/tls_wallet
BUILDER: Creating auto login wallet for server
Oracle PKI Tool Release 23.0.0.0.0 - Production
Version 23.0.0.0.0
Copyright (c) 2004, 2025, Oracle and/or its affiliates. All rights reserved.

Enter password:
Enter password again:
Operation is successfully completed.
BUILDER: Creating a self-signed certificate using orapki utility; VALIDITY: 10 years
Oracle PKI Tool Release 23.0.0.0.0 - Production
Version 23.0.0.0.0
Copyright (c) 2004, 2025, Oracle and/or its affiliates. All rights reserved.

Cannot modify auto-login (sso) wallet
Enter wallet password:
Operation is successfully completed.
BUILDER: exporting server's cert
Oracle PKI Tool Release 23.0.0.0.0 - Production
Version 23.0.0.0.0
Copyright (c) 2004, 2025, Oracle and/or its affiliates. All rights reserved.

Operation is successfully completed.
BUILDER: exporting server's cert
Oracle PKI Tool Release 23.0.0.0.0 - Production
Version 23.0.0.0.0
Copyright (c) 2004, 2025, Oracle and/or its affiliates. All rights reserved.

Operation is successfully completed.
BUILDER: exporting encrypted private key
Oracle PKI Tool Release 23.0.0.0.0 - Production
Version 23.0.0.0.0
Copyright (c) 2004, 2025, Oracle and/or its affiliates. All rights reserved.

Private key password:
Enter password:
Enter password again:
Enter wallet password:
Operation is successfully completed.
BUILDER: exporting private and certificates together in PEM
BUILDER: generating keystore.jks and truststore.jks
Oracle PKI Tool Release 23.0.0.0.0 - Production
Version 23.0.0.0.0
Copyright (c) 2004, 2025, Oracle and/or its affiliates. All rights reserved.

Enter wallet password:
Enter Key store password:
Enter Trust store password:
Operation is successfully completed.
BUILDER: generating sqlnet.ora for client
BUILDER: Generating  tnsnames.ora based on the new CN
BUILDER: Overriding service names based on user input
BUILDER: generating ojdbc.properties
TIME ELAPSED Wallet Generation: 0 minutes and 40 seconds elapsed
User has requested to download '.pdb' archive file from Object Storage bucket
Downloading MY_ATP.pdb..
100%|??????????| 729M/729M [10:56<00:00, 1.16MB/s]
Download complete for MYATP.pdb
PDB archive file saved at: /u01/data/MYATP.pdb
TIME ELAPSED Downloaded PDBs: 10 minutes and 58 seconds elapsed

LSNRCTL for Linux: Version 23.0.0.0.0 - for Oracle Cloud and Engineered Systems on 11-DEC-2025 14:31:22

Copyright (c) 1991, 2025, Oracle.  All rights reserved.

Starting /u01/app/oracle/product/23.0.0.0/dbhome_1/bin/tnslsnr: please wait...

TNSLSNR for Linux: Version 23.0.0.0.0 - for Oracle Cloud and Engineered Systems
System parameter file is /u01/app/oracle/product/23.0.0.0/dbhome_1/network/admin/listener.ora
Log messages written to /u01/app/oracle/diag/tnslsnr/8d8efb51f8dd/listener/alert/log.xml
Listening on: (DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)(HOST=0.0.0.0)(PORT=1521)(FIREWALL=OFF)))
Listening on: (DESCRIPTION=(ADDRESS=(PROTOCOL=tcps)(HOST=0.0.0.0)(PORT=1522)(FIREWALL=OFF)))
Listening on: (DESCRIPTION=(ADDRESS=(PROTOCOL=ipc)(KEY=EXTPROC1521)))

Connecting to (DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=0.0.0.0)(PORT=1521)(FIREWALL=OFF)))
STATUS of the LISTENER
------------------------
Alias                     LISTENER
Version                   TNSLSNR for Linux: Version 23.0.0.0.0 - for Oracle Cloud and Engineered Systems
Start Date                11-DEC-2025 14:31:26
Uptime                    0 days 0 hr. 0 min. 4 sec
Trace Level               off
Security                  ON: Local OS Authentication
SNMP                      OFF
Listener Parameter File   /u01/app/oracle/product/23.0.0.0/dbhome_1/network/admin/listener.ora
Listener Log File         /u01/app/oracle/diag/tnslsnr/8d8efb51f8dd/listener/alert/log.xml
Listening Endpoints Summary...
  (DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)(HOST=0.0.0.0)(PORT=1521)(FIREWALL=OFF)))
  (DESCRIPTION=(ADDRESS=(PROTOCOL=tcps)(HOST=0.0.0.0)(PORT=1522)(FIREWALL=OFF)))
  (DESCRIPTION=(ADDRESS=(PROTOCOL=ipc)(KEY=EXTPROC1521)))
The listener supports no services
The command completed successfully
TIME ELAPSED Listener started: 0 minutes and 4 seconds elapsed

SQL*Plus: Release 23.0.0.0.0 - for Oracle Cloud and Engineered Systems on Thu Dec 11 14:31:26 2025
Version 23.9.0.25.08

Copyright (c) 1982, 2025, Oracle.  All rights reserved.

Connected to an idle instance.

SQL> ORA-32004: obsolete or deprecated parameter(s) specified for RDBMS instance
```





# テストコマンド

```
 lsnrctl status
 
```

https://docs.oracle.com/en/database/oracle/oracle-database/26/jajdb/oracle/jdbc/OracleConnection.html#CONNECTION_PROPERTY_SSL_CONTEXT_PROTOCOL



# DB





```sql


CREATE USER owx IDENTIFIED BY Welcome_1234;

GRANT CONNECT, RESOURCE, CREATE SESSION TO owx;


CREATE USER schema_a_user IDENTIFIED BY Welcome_1234;
GRANT CONNECT, RESOURCE TO schema_a_user;
ALTER USER schema_a_user QUOTA UNLIMITED ON users;

CREATE USER schema_b_user IDENTIFIED BY Welcome_1234;
GRANT CONNECT, RESOURCE TO schema_b_user;
ALTER USER schema_b_user QUOTA UNLIMITED ON users;


///// schema_a_user
CREATE TABLE schema_a_user.table_a (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    status VARCHAR2(50)
);
INSERT INTO schema_a_user.table_a (id, name, status) VALUES (1, 'Initial Data A', 'ACTIVE');
COMMIT;


///// schema_b_user
CREATE TABLE schema_b_user.table_b (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    status VARCHAR2(50)
);
INSERT INTO schema_b_user.table_b (id, name, status) VALUES (1, 'Initial Data B', 'ACTIVE');
COMMIT;


GRANT SELECT, INSERT, UPDATE, DELETE ON schema_b_user.table_b TO owx;
GRANT SELECT, INSERT, UPDATE, DELETE ON schema_a_user.table_a TO owx;


```





```
<msg time='2025-12-12T09:21:47.972+00:00' org_id='oracle' comp_id='tnslsnr'
 type='UNKNOWN' level='16' host_id='8d8efb51f8dd'
 host_addr='192.168.10.128' pid='13' seclabel='3'>
 <txt>12-DEC-2025 09:21:47:972 * (ADDRESS=(PROTOCOL=tcps)(HOST=192.168.10.105)(PORT=3795)(FIREWALL=OFF)) * &lt;unknown connect data&gt; * 29019
ORA-29019: The protocol version is incorrect.
 TNS-00542: SSL Handshake failed
  TNS-12560: Database communication protocol error.
   TNS-00542: SSL Handshake failed

 </txt>
</msg>
```




https://medium.com/oracledevs/retrieval-augmented-generation-rag-with-spring-ai-oracle-database-23ai-and-openai-61281b96d18a
























###################################

podman run -d -p 1521:1521 -e ORACLE_PWD=Welcome_1234 -v oracle-volume:/opt/oracle/oradata container-registry.oracle.com/database/free:latest
