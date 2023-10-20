run-dist:
	make -C app run-dist

test:
	make -C app test

lint:
	make -C app lint

report:
	make -C app report

build:
	make -C app build

.PHONY:
	build