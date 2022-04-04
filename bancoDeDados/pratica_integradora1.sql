CREATE TABLE "pedido" (
  "id" SERIAL PRIMARY KEY,
  "id_cliente" int,
  "id_item_pedido" int,
  "data" datetime
);

CREATE TABLE "item_pedido" (
  "id" SERIAL PRIMARY KEY,
  "id_produto" int,
  "quantidade" int
);

CREATE TABLE "cliente" (
  "id" SERIAL PRIMARY KEY,
  "nome" varchar,
  "sobrenome" varchar,
  "id_endereco" int,
  "email" varchar
);

CREATE TABLE "produto" (
  "id" SERIAL PRIMARY KEY,
  "descricao" varchar,
  "valor" decimal
);

CREATE TABLE "endereco" (
  "id" SERIAL PRIMARY KEY,
  "rua" varchar,
  "numero" int,
  "complemento" varchar,
  "cidade" varchar,
  "uf" varchar(2)
);

ALTER TABLE "pedido" ADD FOREIGN KEY ("id_cliente") REFERENCES "cliente" ("id");

ALTER TABLE "item_pedido" ADD FOREIGN KEY ("id") REFERENCES "pedido" ("id_item_pedido");

ALTER TABLE "item_pedido" ADD FOREIGN KEY ("id_produto") REFERENCES "produto" ("id");

ALTER TABLE "cliente" ADD FOREIGN KEY ("id_endereco") REFERENCES "endereco" ("id");
