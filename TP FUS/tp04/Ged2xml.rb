#!/usr/bin/ruby

# Message donnant la syntaxe d'utilisation
syntaxe="Usage : #{$0} FichierOrigine.ged FichierResultat.txt"

# Vérification du nombre de paramètres
# Pour calculer le nombre de paramètres, on utilise la fonction ...
nbarg=ARGV.size
if (nbarg!=2) then abort syntaxe ; end

# Renommage des paramètres
(entree, sortie)=ARGV

# Vérification de l'existence des fichiers
if (! File.exist?(entree))
	abort "\t[Erreur: Le fichier d'entrée #{entree} n'existe pas]\n";
end
=begin
if (File.exist?(sortie))
	abort "\t[Erreur: Le fichier de sortie #{sortie} existe déjà]\n";
end
=end

# Ouverture du fichier d'entrée
begin
  fe=File.open(entree,"r") 
  rescue Errno::ENOENT
    abort "\t[Erreur: Echec d'ouverture du fichier d'entrée #{entree}]\n"
end

# Ouverture du fichier de sortie
begin
	fs=File.open(sortie,"w") 
	rescue Errno::ENOENT
		abort "\t[Erreur: Echec d'ouverture du fichier de sortie #{sortie}]\n"
end

# Redirection du fichier de sortie vers la sortie standard dans la phase de test
#fs=STDOUT

# Last tag level
last_tag_level = 0
# Stack of tags opened and closed
tag_stack = []

# Boucle de lecture du fichier d'entrée
begin
	while line=fe.readline
		#fs.print line

		# Retrait des blancs en fin de ligne
		line.sub!(/\s+$/, "")

		# Séparation des lignes en 2 parties : le chiffre et le reste
		if (line =~ /\s*(\d+)\s+(.*)$/)
			niv = $1.to_i
			remainder = $2
      fs.print "\t" * niv
			print "Trouver le truc 1 : #{niv} et le truc 2 : #{remainder}\n"
		end

		# Fermeture des balises (à faire en dernier)
		if (last_tag_level > niv)
      fs.print "sortir #{last_tag_level}\n"
			while last_tag_level > niv
				last_tag_level -= 1
        fs.print "</" , tag_stack.pop , ">\n"
        fs.print "\t" * last_tag_level
			end
    elsif (last_tag_level < niv)
			last_tag_level = niv
		end
		
    if (remainder =~ /^HEAD$/)
		# Sélection des lignes de la classe des identificateurs @...@ (INDI,FAM)
		# Class 2 Line
		elsif (line =~ /@(\d+)@\s*(INDI|FAM)$/)
			balise=$2
      tag_stack.push($2)
			fs.print("<#{balise} ID=\"#{$1}\">\n")
		# Sélections des lignes de la classe NAME
		# Class 1 Line
		elsif (remainder =~ /NAME ([\s\w].*)\/([A-Z\-].*)\//)
			fs.print "<NAME>#{$1}<S>#{$2}</S></NAME>\n"

		# Sélection des lignes avec un identificateur de fin (FAMS, FAMC, HUSB, WIFE, CHIL...)
		# Class 3 Line
		elsif (/(?<balise>FAMS|FAMC|HUSB|WIFE|CHIL|)\s+@(?<id>\d+)@/ =~ remainder)
			fs.print "<#{balise} REF=\"#{id}\"></#{balise}>\n"

		# Class 4 Lines : It's just a tag
		elsif (/(?<tag>BIRT|DEAT|MARR|MARC)/ =~ remainder)
			fs.print "<EVEN EV=\'#{tag}\'>\n"
			tag_stack.push("EVEN")
			print "DEBUG=#{tag_stack}\n"

		elsif (/(?<tag>SEX|OCCU|DATE|PLAC)\s+(?<data>.*)$/ =~ remainder)
      fs.print "<#{tag}>#{data}</#{tag}>\n"

		#Cas non prévus
		else
			print("Ligne non prévue: #{line}\n") 	
		end
      fs.print "niveau #{niv}\n"

		# Mémorisation de l'ancien niveau
	end
	rescue EOFError
end
# Fermeture des balises non fermées
while not tag_stack.empty?
  fs.print "\t" * (tag_stack.size-1), "</", tag_stack.pop, ">\n"
end

fe.close
#fs.close






