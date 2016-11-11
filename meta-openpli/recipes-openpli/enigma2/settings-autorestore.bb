PV = "20151205"
SRC_URI = "file://*"
DESCRIPTION = "Autorecover settings and install packages at first boot from /media/*/backup"
PACKAGES = "${PN}"
MAINTAINER = "MiLo@OpenPLi"

require conf/license/openpli-gplv2.inc

# Need to tell bitbake that we have extra files installed
FILES_${PN} = "/etc"

S = "${WORKDIR}"

# Not inheriting from rc-update because the script commits suicide, which
# confuses the pkg scripts.
do_install() {
	install -d ${D}/etc/init.d
	install -d ${D}/etc/rcS.d
	# run-once initialization script
	install -m 755 ${S}/settings-restore.sh ${D}/etc/init.d/settings-restore.sh
	install -m 755 ${S}/settings-restore.old.sh ${D}/etc/init.d/settings-restore.old.sh
	install -m 755 ${S}/autoinstall.sh ${D}/etc/init.d/autoinstall.sh
        install -m 755 ${S}/initautoinstall.sh ${D}/etc/init.d/initautoinstall.sh
}

# Safeguard: Don't activate on a running image
pkg_postinst_${PN}() {
	if [ "x$D" != "x" ]
	then
		ln -sf ../init.d/initautoinstall.sh $D/etc/rc3.d/S99initautoinstall.sh
	fi
}

inherit allarch
